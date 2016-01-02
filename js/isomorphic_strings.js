var uUnit = require('./uUnit');

var isimp = function(left, right) {
  if (left === right)
    return true;

  if (left.length !== right.length)
    return false;

  var charMap = Object.create(null),
    charReverseMap = Object.create(null);

  for (var i = 0; i < left.length; i += 1) {
    var lc = left[i],
      rc = right[i];

    if (charMap[lc] && charMap[lc] !== rc)
      return false;

    if (charReverseMap[rc] && charReverseMap[rc] !== lc)
      return false;

    charMap[lc] = rc;
    charReverseMap[rc] = lc;
  }

  return true;
};

uUnit.run({
  'two empty strings are isomorphic': function(assert) {
    assert.true(isimp('', ''));
  },

  'two identical strings are isomorphic': function(assert) {
    assert.true(isimp('foo', 'foo'));
    assert.true(isimp('motherfucker', 'motherfucker'));
    assert.true(isimp('golang', 'golang'));
  },

  'two strings that have different lengths are not isomorphic': function(assert) {
    assert.false(isimp('foo', 'f'));
    assert.false(isimp('foo', ''));
    assert.false(isimp('xxx', 'yyyxxx'));
  },

  'for isomorphic strings returns true': function(assert) {
    assert.true(isimp('aazzxx', 'bbcczz'));
    assert.true(isimp('abcde', 'edcba'));
    assert.true(isimp('11ccyui', 'xx99abc'));
    assert.true(isimp('abcde', 'bcdea'));
  },

  'for not isomorphic strings returns false': function(assert) {
    assert.false(isimp('abcdef', 'abcdea'));
    assert.false(isimp('xxxyyy', 'yyyyxx'));
    assert.false(isimp('1122334', 'aabbccc'));
    assert.false(isimp('1991', 'addc'));
  }
});
