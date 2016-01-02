
var uUnit = require('./uUnit');

var llw = function(s) {
  var end = s.length-1;
  while (end >= 0 && s[end] === ' ')
    end--;

  if (end === (-1))
    return 0;

  // s[end] - last character of the last word

  var begin = end;
  while (begin >= 1 && s[begin-1] !== ' ')
    begin--;

  // s[begin] - first characer of the last word

  return end - begin + 1;
};

uUnit.run({
  'length of last word tests': function(assert) {
    assert.equal(0, llw('   '));
    assert.equal(1, llw('  a  '));
    assert.equal(2, llw('foo bar aa  '));
    assert.equal(4, llw('abcd'));
    assert.equal(0, llw(''));
    assert.equal(2, llw('ay  '));
  }
});
