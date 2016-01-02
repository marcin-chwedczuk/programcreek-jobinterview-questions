var uUnit = require('./uUnit');

var norep = function(string) {
  if (string.length < 2)
    return string.length;

  var start = 0,
      stop = 0,
      max = 1,
      set = Object.create(null);

  for (var stop = 0; stop < string.length; stop += 1) {
    if (string[stop] in set) {
      while (string[start] !== string[stop]) {
        delete set[string[start]];
        start++;
      }
      start++;
    }
    else {
      set[string[stop]] = true;
      max = Math.max(max, stop - start + 1);
    }
  }

  return max;
};

uUnit.run({
  'boundary conditions': function(assert) {
      assert.equal(0, norep(''));
      assert.equal(1, norep('a'));
      assert.equal(2, norep('ab'));
      assert.equal(1, norep('aa'));
  },

  'finds largest susbstring of non repeating characters': function(assert) {
    assert.equal(7, norep('bacdbefg'));
    assert.equal(3, norep('abcbcd'));
    assert.equal(1, norep('aaaaaa'));
    assert.equal(2, norep('abaaaa'));
  }
});
