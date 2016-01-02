
var uUnit = require('./uUnit');

var twoSumNaive = function(array, sum) {
  for(var i = 0; i < array.length; i += 1) {
    var target = sum - array[i];

    for (var j = i+1; j < array.length; j += 1) {
      if (array[j] === target)
        return [i+1, j+1];
    }
  }

  return null;
};

var twoSumHash = function(array, sum) {
  var hashmap = Object.create(null);

  array.forEach(function(n, index) {
    hashmap[sum - n] = index + 1;
  });

  for (var i = 1; i <= array.length; i += 1) {
    var j = hashmap[array[i-1]];
    if (j && j !== i)
      return [Math.min(i,j), Math.max(i,j)];
  }

  return null;
};

var twoSum = twoSumHash;

uUnit.run({
  'twoSum tests': function(assert) {
    assert.arrayEqual([1,2], twoSum([1,2,3,4,5], 3));
    assert.arrayEqual([3,4], twoSum([1,2,3,7,1], 10));
    assert.arrayEqual([1,5], twoSum([113,2,3,4,-100], 13));
  }
});
