
var uUnit = require('./uUnit');

var isEven = function(n) { return (n % 2) === 0; };

var binarySearch = function(array, start, stop, element) {
  // TODO: Replace by binary search
  var i = firstIndex(
    array.slice(start, stop),
    function(x) { return x > element; });

  if (i === (-1))
    return stop;

  return start + i;

  function firstIndex(array, predicate) {
    for (var i = 0; i < array.length; i += 1) {
      if (predicate(array[i]))
        return i;
    }

    return (-1);
  }
};

var kth =  function(k, a, astart, astop, b, bstart, bstop) {
  // console.log([k, astart, astop, bstart, bstop].join(', '));

  // if a is empty - return b kth element
  if (astart >= astop)
    return b[k + bstart];

  // if b is empty - return a kth element
  if (bstart >= bstop)
    return a[k + astart];

  // return 0'th element
  if (!k)
    return (a[astart] < b[bstart] ? a[astart] : b[bstart]);

  // find a median
  var aNew = Math.floor((astart + astop)/2);
  var belowANew = aNew - astart;

  // bNew - b[index >= bNew] > a[aNew]
  // bNew may be equal to bstop
  var bNew = binarySearch(b, bstart, bstop, a[aNew]);
  var belowBNew = bNew - bstart;

  if (k < belowANew + belowBNew) {
    return kth(k, a, astart, aNew, b, bstart, bNew);
  }
  else if (k === (belowANew + belowBNew)) {
    return a[aNew];
  }
  else {
    return kth(k - (belowANew+belowBNew+1), a, aNew+1, astop, b, bNew, bstop);
  }
};

var median2 = function(left, right) {
  var totalLength = left.length + right.length;
  var medianStart = isEven(totalLength) ?
    totalLength/2-1 :
    totalLength/2;

  if (isEven(totalLength))
    return [kth(medianStart, left, 0, left.length, right, 0, right.length),
            kth(medianStart+1, left, 0, left.length, right, 0, right.length)];
  else
    return kth(medianStart, left, 0, left.length, right, 0, right.length);
};

uUnit.run({
  'kth - boundary conditions': function(assert) {
    assert.equal('x', kth(0, ['x'], 0, 1, [], 0, 0));
    assert.equal('x', kth(0, [], 0, 0, ['x'], 0, 1));

    assert.equal('x', kth(0, ['x'], 0, 1, ['y'], 0, 1));
    assert.equal('y', kth(1, ['x'], 0, 1, ['y'], 0, 1));
  },

  'kth - zipped arrays': function(assert) {
    var a = [1,3,5,7,9,11],
        b = [0,2,4,6,8,10];

    for (var i = 0; i < 12; i += 1) {
      assert.equal(i, kth(i, a, 0, a.length, b, 0, b.length));
    }
  },

  'kth - one before other': function(assert) {
    var a = [1,2,3], b = [101, 102, 103],
        all = a.concat(b);

    for (var i = 0; i < all.length; i += 1) {
      assert.equal(all[i], kth(i, a, 0, a.length, b, 0, b.length));
      assert.equal(all[i], kth(i, b, 0, b.length, a, 0, a.length));
    }
  },

  'kth - one array longer than other': function(assert) {
    var a = [1,2,3], b = [101,102,103,104,105,107,108,109],
        all = a.concat(b);

    for (var i = 0; i < all.length; i += 1) {
      assert.equal(all[i], kth(i, a, 0, a.length, b, 0, b.length));
      assert.equal(all[i], kth(i, b, 0, b.length, a, 0, a.length));
    }
  },

  'kth - boundary conditions - single elemnt array': function(assert) {
    var a = [4], b = [1,2,3,5,6],
        all = [1,2,3,4,5,6];

    for (var i = 0; i < all.length; i += 1) {
      assert.equal(all[i], kth(i, a, 0, 1, b, 0, b.length));
      assert.equal(all[i], kth(i, b, 0, b.length, a, 0, 1));
    }
  }
});
