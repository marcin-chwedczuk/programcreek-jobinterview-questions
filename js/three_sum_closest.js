
var uUnit = require('./uUnit');

var threeSumClosest = function(array, target) {
  array.sort(function(l,r) { return l-r; });

  var bestSoFar = Number.MAX_VALUE, bestSum;

  outer: for (var i = 0; i < array.length; i += 1) {
    var target_i = target - array[i];
    var pmin = i+1;
    var pmax = array.length-1;

    // a[pmin] + a[pmax] must be closest to target_i
    inner: while (pmin < pmax) {
      var curr = target_i - (array[pmin]+array[pmax]);
      var currAbs = Math.abs(curr);

      if (currAbs < bestSoFar) {
        bestSoFar = currAbs;
        bestSum = target - curr;
      }

      if (curr < 0) {
        pmax -= 1;
      }
      else if (curr > 0) {
        pmin += 1;
      }
      else {
        break outer;
      }
    }
  }

  return bestSum;
};

uUnit.run({
  'threeSumClosest works': function(assert) {
    assert.equal(2, threeSumClosest([-1,2,1,4], 1));
  }
});
