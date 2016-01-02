
var uUnit = require('./uUnit');

/* array must be sorted [min ... max] */
var twoSumSorted = function(array, sum) {
  var pmin = 0, pmax = array.length-1;

  while (pmin < pmax) {
    var currSum = array[pmin] + array[pmax];

    if (currSum === sum)
      return [pmin+1, pmax+1];
    else if (currSum < sum)
      pmin += 1;
    else // (currSum > sum)
      pmax -= 1;
  }

  return null;
};

uUnit.run({
  'twoSumSorted works': function(assert) {
      var array = [1,2,3,4,5,6,7,8,9,10];

      assert.arrayEqual(null, twoSumSorted(array, 0));
      assert.arrayEqual(null, twoSumSorted(array, 1000));

      assert.arrayEqual([1,2], twoSumSorted(array, 3));
      assert.arrayEqual([7,10], twoSumSorted(array, 7+10));

      assert.arrayEqual([2,10], twoSumSorted(array, 12));
  }
});
