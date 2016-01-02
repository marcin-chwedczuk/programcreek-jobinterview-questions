var uUnit = require('./uUnit');

var findLCS = function(array) {
  var ivs = Object.create(null),
      max = 0;

  for (var i = 0; i < array.length; i += 1) {
    var n = array[i],
        upper = null,
        lower = null;

    // no duplicates
    if (ivs[n]) continue;

    lower = ivs[n-1] || null;
    upper = ivs[n+1] || null;

    delete ivs[n-1];
    delete ivs[n+1];

    max = Math.max(max, merge(ivs, lower, n, upper));
  }

  return max;

  function merge(ivs, lower, n, upper) {
    if (!lower && !upper) {
      ivs[n] = { from:n, to:n };
      return 1;
    }
    else if (!lower && upper) {
      ivs[n] = ivs[upper.to] = { from:n, to:upper.to };
      return (upper.to - n + 1);
    }
    else if (lower && !upper) {
      ivs[lower.from] = ivs[n] = { from:lower.from, to:n };
      return (n - lower.from + 1);
    }
    else {
      ivs[lower.from] = ivs[upper.to] = { from:lower.from, to:upper.to };
      return (upper.to - lower.from + 1);
    }
  }
};

uUnit.run({
  'it works': function(assert) {
    assert.equal(4, findLCS([100,4,200,1,3,2]));
    assert.equal(1, findLCS([1,10,100]));
    assert.equal(4, findLCS([3,6,8,4,5]));
  }
});
