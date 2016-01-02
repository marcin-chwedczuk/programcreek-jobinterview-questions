
var uUnit = require('./uUnit');

var diff1 = function(left, right) {
  if (left.length != right.length)
    return false;

  var count = 0;
  for (var i = 0; i < left.length; i += 1) {
    if (left[i] !== right[i]) {
      count++;
      if (count > 1) return false;
    }
  }

  return (count === 1);
};

var printGraph = function(graph) {
  console.log('-------------------------');
  for (var startNode in graph) {
    var edges = graph[startNode];
    console.log(startNode + ': ' + edges.join(', '));
  }
};

var buildWordGraph = function(dict) {
  var graph = Object.create(null);

  for (var i = 0; i < dict.length; i += 1) {
    graph[dict[i]] = [];

    for (var j = 0; j < dict.length; j += 1) {
      if (!diff1(dict[i], dict[j]))
        continue;

      graph[dict[i]].push(dict[j]);
    }
  }

  return graph;
};

var wordPathGraph = function(dict, start, stop) {
  dict = dict.concat([start, stop]);

  var graph = buildWordGraph(dict);

  // BFS
  var path = Object.create(null),
      q = [start];

  path[start] = start;
  while (q.length) {
    var node = q.shift();
    if (node === stop) {
      break;
    }

    for (var k = 0; k < graph[node].length; k += 1) {
      if (!path[graph[node][k]]) {
        q.push(graph[node][k]);
        path[graph[node][k]] = node;
      }
    }
  }

  // restore path
  if (!path[stop])
    return [];

  var p = [stop], curr = stop;
  do {
    curr = path[curr];
    p.push(curr);
  }
  while (curr != start);

  p.reverse();
  return p;
};

var buildEndSet = function(dict, stop) {
  var set = Object.create(null);

  for(var i = 0; i < dict.length; i += 1) {
    if (diff1(dict[i], stop))
      set[dict[i]] = true;
  }

  return set;
};

var extend = function(set, word, graph) {
  var diff1Words = graph[word];
  for (var i = 0; i < diff1Words.length; i += 1) {
    set[diff1Words[i]] = true;
  }
};

var wordPathIter = function(dict, start, stop) {
  var set = Object.create(null);

  var graph = buildWordGraph(dict.concat([start, stop]));

  set[start] = true;

  for (var i = 0; i <= dict.length; i += 1) {
    var newSet = Object.create(null);
    for(var word in set) {
      extend(newSet, word, graph);
    }
    set = newSet;

    if (set[stop])
      return (i+2); // number of nodes = number of inner edges + 2
  }

  return 0;
};

(function() {
    var start = 'hit', stop = 'cog',
        dict = ['hot', 'dot', 'dog', 'lot', 'log'];
  console.log('RES ' + wordPathIter(dict, start, stop));

  console.log('RES2 ' + wordPathIter(['b'], 'a', 'c'));
}());

var wordPath = wordPathGraph;

uUnit.run({
  'diff1 returns true for words that differ on exactly 1 letter': function(assert) {
      assert.true(diff1('ala', 'alz'));
      assert.true(diff1('xxy', 'yxy'));
      assert.true(diff1('hurrafu', 'hurrahu'));
      assert.true(diff1('miyako', 'Miyako'));

      assert.false(diff1('ala', 'xxa'));
      assert.false(diff1('xxx', 'yyy'));
      assert.false(diff1('ala', 'ala'));
  },

  'wordPath finds shortest path between words': function(assert) {
    var start = 'hit', stop = 'cog',
        dict = ['hot', 'dot', 'dog', 'lot', 'log'];

    var path = wordPath(dict, start, stop);
    assert.arrayEqual(['hit', 'hot', 'dot', 'dog', 'cog'], path);
  },

  'wordPath finds SPBW (diamond graph)': function(assert) {
    var start = 'aaa', stop = 'bab',
        dict = ['baa', 'aab'];

    var path = wordPath(dict, start, stop);
    assert.arrayEqual(['aaa', 'baa', 'bab'], path);
  },

  'wordPath finds SPBW (cycle)': function(assert) {
    var start = 'aaaaaa', stop = 'cccccc',
        dict = ['aaaaab', 'aaaabb', 'aaabbb',
          'aabbbb', 'abbbbb', 'bbbbbb',
          'bbbbbc', 'bbbbcc', 'bbbccc',
          'bbcccc', 'bccccc',
          'accccc', 'aacccc', 'aaaccc',
          'aaaacc', 'aaaaac'];

    var path = wordPath(dict, start, stop);
    assert.arrayEqual(
      ['aaaaaa', 'aaaaac', 'aaaacc', 'aaaccc', 'aacccc', 'accccc', 'cccccc'],
      path);
  }
});
