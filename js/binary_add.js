
var uUnit = require('./uUnit');

var add = function(left, right) {
  var carry = 0,
      result = [];

  var pos = 0,
      maxLen = Math.max(left.length, right.length) + 1;

  while (pos < maxLen) {
    var l = (pos < left.length ? left[left.length-1 - pos] : '0');
    var r = (pos < right.length ? right[right.length-1 - pos] : '0');

    l = (l === '1' ? 1 : 0);
    r = (r === '1' ? 1 : 0);

    carry = l + r + carry;
    result.unshift(carry % 2);

    carry = Math.floor(carry / 2);

    pos += 1;
  }

  // remove leading zeros
  while (result.length > 1 && result[0] === 0)
    result.shift();

  return result.join('');
};

uUnit.run({
  'add binary numbers works': function(assert) {
    assert.equal('101', add('000', '101'));
    assert.equal('101', add('101', '000'));

    assert.equal('1001101', add('1', '1001100'));

    assert.equal('10', add('1','1'));
    assert.equal('10100', add('10001', '11'));

    assert.equal('1000', add('111', '1'));
  }
});
