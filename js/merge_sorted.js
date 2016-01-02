var uUnit = require('./uUnit');

var mergeSorted = function(a, alength, b) {
  var length = alength + b.length;
  var end = length - 1,
      aend = alength - 1,
      bend = b.length - 1;

  while (aend >= 0 && bend >= 0) {
    if (a[aend] >= b[bend]) {
      a[end--] = a[aend--];
    }
    else {
      a[end--] = b[bend--];
    }
  }

  /* elements of a are already on right positions, we can skip:
  while (aend >= 0) {
    a[end--] = a[aend--];
  }*/

  while (bend >= 0) {
    a[end--] = b[bend--];
  }
};

uUnit.run({
  'mergeSorted merges two arrays': function(assert) {
    var a = [3,7,9,12, 0,0,0,0];
    var b = [1,2,5,14];

    mergeSorted(a, 4, b);

    var expected = [1,2,3,5,7,9,12,14];
    assert.arrayEqual(expected, a);
  },

  'mergeSorted b before a': function(assert) {
    var a = [1,2,3, 0,0];
    var b = [-10, -8];

    mergeSorted(a, 3, b);

    var expected = [-10,-8,1,2,3];
    assert.arrayEqual(expected, a);
  },

  'mergeSorted a before b': function(assert) {
    var a = [1,2,3, 0,0];
    var b = [101,102];

    mergeSorted(a, 3, b);

    var expected = [1,2,3,101,102];
    assert.arrayEqual(expected, a);
  }
});
