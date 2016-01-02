var uUnit = require('./uUnit');

var threeSum = function(array) {
  var solutions = [];

  for (var i = 0; i < array.length; i += 1) {
    for (var j = i+1; j < array.length; j += 1) {
      var partial = -(array[i] + array[j]);

      for (var k = j+1; k < array.length; k += 1) {
        if (array[k] === partial) {
          var s = [array[i], array[j], array[k]];
          s.sort(function(l, r) { return (l-r); });

          if (!solutions.some(function(a) { return a.join(':') === s.join(':'); }))
            solutions.push(s);
        }
      }
    }
  }

  return solutions;
};

var CMP_ARRAY_AS_STRINGS = function(larray, rarray) {
  return (larray.join(':') === rarray.join(':'));
};

uUnit.run({
  'test threeSum': function(assert) {
    var actual = threeSum([-1,0,1,2,-1,4]);
    var expected = [[-1,0,1], [-1,-1,2]];

  assert.arrayEqual(expected, actual, CMP_ARRAY_AS_STRINGS);
  }
});
