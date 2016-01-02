
var uUnit = require('./uUnit');

var hasdup = function(array, maxGap) {
  var set = Object.create(null);

  for (var i = 0; i < array.length; i += 1) {
    if (array[i] in set) {
      if (i - set[array[i]] <= maxGap)
        return true;
    }
    set[array[i]] = i;
  }

  return false;
};

uUnit.run({
  'duplicates2 works': function(assert) {
    assert.false(hasdup([1,2,3], 1));
    assert.false(hasdup([1,2,3], 100));

    assert.false(hasdup([], 100));
    assert.false(hasdup([1], 1));

    assert.true(hasdup([1,1],1));
    assert.false(hasdup([1,2,1], 1));
    assert.true(hasdup([1,2,1], 2));
    assert.true(hasdup([1,2,1], 4));

    assert.true(hasdup([1,1.1,1.2,1.3,1.4,1], 5));
  }
});
