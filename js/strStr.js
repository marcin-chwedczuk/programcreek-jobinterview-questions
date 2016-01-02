var uUnit = require('./uUnit');

var strStr = function(haystack, needle) {
  if (haystack.length < needle.length)
    return false;

  if (needle.length === 0)
    return 0;

  var pos = 0,
      needleHash = computeHash(needle, 0, needle.length),
      currHash = computeHash(haystack, 0, needle.length);

  for (pos = 0; pos < haystack.length-needle.length+1; pos += 1) {
    if (pos) {
      // fix hash
      currHash -= computeHash(haystack, pos-1, pos);
      currHash += computeHash(haystack, pos+needle.length-1, pos+needle.length);
    }

    if (currHash == needleHash && equalAtCurrentPos())
      return pos;
  }

  return (-1);

  function computeHash(string, start, stop) {
    var h = 0;

    for (var i = start; i < stop; i += 1) {
      h = h + string.charCodeAt(i);
    }

    return h;
  }

  function equalAtCurrentPos() {
    for (var i = 0; i < needle.length; i += 1) {
      if (needle[i] !== haystack[pos + i])
        return false;
    }

    return true;
  }
};

uUnit.run({
  'it works': function(assert) {
    assert.equal(3, strStr('barfoo', 'foo'));
    assert.equal(-1, strStr('barfoo', 'nya'));
    assert.equal(2, strStr('foyya', 'yya'));
  }
});
