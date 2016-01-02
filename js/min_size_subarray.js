var uUnit = require('./uUnit');

var minSizeSubarray = function(array, s) {
  var minSize = Number.MAX_SAFE_INTEGER;

  var pstart = 0,
      pstop = 0,
      sum = array[0],
      minL = 10000;

  // sum = (+).apply( array[pstart ... pstop] )
  while (pstart < array.length) {
    if (sum < s) {
      if (pstop < array.length) {
        pstop += 1;
        sum += array[pstop];
      }
      else {
        return minL;
      }
    }
    else {
      if (pstart < pstop) {
        sum -= array[pstart];
        pstart += 1;
      }
      else if (pstart === pstop) {
        pstart = pstop = (pstart + 1);
        sum = array[pstart];
      }
    }

    if (sum >= s) minL = Math.min(minL, pstop-pstart+1);
  }

  return minL;
};

uUnit.run({
  'it works': function(assert) {
    assert.equal(2, minSizeSubarray([2,3,1,2,4,3], 7));
  }
});
