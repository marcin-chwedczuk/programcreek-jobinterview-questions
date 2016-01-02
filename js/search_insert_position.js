var uUnit = require('./uUnit');

/* @param array Sorted array. */
var insposNaive = function(array, value) {
  var i;

  for (i = 0; i < array.length; i += 1) {
    if (array[i] >= value)
      break;
  }

  return i;
};

var insposBinary = function(array, value) {
  var left = 0,
      right = array.length;

  while (left < right) {
    // assert array[left] <= value || array[0] > value
    var mid = Math.floor((left+right) / 2);

    if (array[mid] < value) {
      left = mid+1;
    }
    else if (array[mid] > value) {
      right = mid;
    }
    else {
      return mid;
    }
  }

  return left;
};

var inspos = insposBinary;

uUnit.run({
  'insert before all': function(assert) {
    assert.equal(0, inspos([1,2,3], -5));
  },

  'insert after all': function(assert) {
    assert.equal(4, inspos([1,2,3,4], 5));
  },

  'insert inside array': function(assert) {
    assert.equal(2, inspos([2,4,5,6], 4.5));
  },

  'element exists': function(assert) {
    var arr = [0,1,2,3,4,5,6,7,8];

    for (var i = 0; i < arr.length; i += 1) {
      assert.equal(i, inspos(arr, i));
    }
  },

  'boundary conditions': function(assert) {
    assert.equal(0, inspos([], 3));
    assert.equal(0, inspos([1], 0));
    assert.equal(1, inspos([1], 2));
  }
});
