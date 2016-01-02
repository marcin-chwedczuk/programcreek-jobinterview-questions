
var uUnit = require('./uUnit');
var interval = require('./interval');

var iv = interval.iv,
    INTERVAL_EQUALITY = interval.INTERVAL_EQUALITY;

var insertInterval = function(intervals, intervalToInsert) {
  var result = [];

  intervals.forEach(function(v) {
    // already inserted
    if (intervalToInsert == null) {
      result.push(v);
    }
    // before merge or (after merge & before insert)
    else if (!v.overlaps(intervalToInsert)) {
      // insert - if we are in the right place
      if (intervalToInsert.stop < v.start) {
        result.push(intervalToInsert);
        intervalToInsert = null;
      }

      result.push(v);
    }
    // during merge - merge overlapping intervals
    else {
      intervalToInsert = intervalToInsert.merge(v);
    }
  });

  if (intervalToInsert)
    result.push(intervalToInsert);

  return result;
};

uUnit.run({
  'insert interval #1': function(assert) {
    var actual = insertInterval([iv(1,3), iv(6,9)], iv(2,5));
    var expected = [iv(1,5), iv(6,9)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'insert interval #2': function(assert) {
    var actual = insertInterval([iv(1,2), iv(3,5), iv(6,7), iv(8,10), iv(12, 16)], iv(4,9));
    var expected = [iv(1,2), iv(3,10), iv(12,16)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'insert interval before all': function(assert) {
    var actual = insertInterval([iv(1,2), iv(3,5)], iv(-3,0));
    var expected = [iv(-3,0), iv(1,2), iv(3,5)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'insert interval after all': function(assert) {
    var actual = insertInterval([iv(1,2), iv(3,5)], iv(10,11));
    var expected = [iv(1,2), iv(3,5), iv(10,11)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'insert interval with all merge': function(assert) {
    var actual = insertInterval([iv(1,2), iv(3,5)], iv(1.5, 4));
    var expected = [iv(1,5)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'insert with partial merge': function(assert) {
    var actual = insertInterval([iv(-4,-3), iv(-2,-1), iv(0,1), iv(3,5), iv(7,10)], iv(0.5, 4));
    var expected = [iv(-4,-3), iv(-2,-1), iv(0, 5), iv(7,10)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  },

  'insert no merge': function(assert) {
    var actual = insertInterval([iv(0,1), iv(10,11)], iv(5,6));
    var expected = [iv(0,1), iv(5,6), iv(10,11)];

    assert.arrayEqual(expected, actual, INTERVAL_EQUALITY);
  }
});
