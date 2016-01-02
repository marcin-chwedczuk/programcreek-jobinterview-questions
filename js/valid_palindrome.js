var uUnit = require('./uUnit');

var isValid = function(string) {
  var left = 0, right = string.length-1;

  while (left < right) {
      if (!isAlpha(string[left])) {
        left += 1;
      }
      else if (!isAlpha(string[right])) {
        right -= 1;
      }
      else if (string[left].toLowerCase() !== string[right].toLowerCase()) {
        return false;
      }
      else {
        left += 1; right -= 1;
      }
  }

  return true;

  function isAlpha(c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }
};

uUnit.run({
  'it works': function(assert) {
    assert.true(isValid('Red rum, sir, is murder'));
    assert.false(isValid('awesome'));
  }
});
