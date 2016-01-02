
var uUnit = require('./uUnit');
var interval = require('./interval');

var iv = interval.iv,
    INTERVAL_EQUALITY = interval.INTERVAL_EQUALITY;

/* intervals = array of { start, stop } pairs
   intervals are close-open type. */
var mergeIntervals = function(intervals) {
  intervals.sort(function(leftIv, rightIv) {
    return leftIv.start - rightIv.start;
  });

  var merged = [iv(intervals[0].start, intervals[0].stop)];
  var stop = intervals[0].stop;

  for (var i = 1; i < intervals.length; i += 1) {
  var currIv = intervals[i];

    if (currIv.start <= stop) {
      stop = Math.max(stop, currIv.stop);
      merged[merged.length-1].stop = stop;
    }
    else {
      merged.push(iv(currIv.start, currIv.stop));
      stop = currIv.stop;
    }
  }

  return merged;
};

uUnit.run({
  'mI given non overlapping intervals returns passed intervals sorted by lower bonds': function(assert) {
    var actual = mergeIntervals([iv(1,2), iv(-3,-2), iv(101, 103), iv(5,7)]);
    var expected = [iv(-3,-2), iv(1,2), iv(5,7), iv(101,103)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'mI given two same intervals returns only one instance of it': function(assert) {
    var actual = mergeIntervals([iv(1,10), iv(1,10)]);
    var expected = [iv(1,10)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'mI expects open close intervals': function(assert) {
    var actual = mergeIntervals([iv(0,1), iv(1, 2)]);
    var expected = [iv(0,2)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'mI correctly merges nested intervals': function(assert) {
    var actual = mergeIntervals([iv(0,1), iv(-3, 3), iv(-5, 5)]);
    var expected = [iv(-5,5)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'mI correctly merges overlapping intervals': function(assert) {
    var actual = mergeIntervals([iv(1,3), iv(2,6), iv(8,10), iv(15,18)]);
    var expected = [iv(1,6), iv(8,10), iv(15,18)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  }
});
