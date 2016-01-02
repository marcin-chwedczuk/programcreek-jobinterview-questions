var uUnit = require('./uUnit');

var zigZag = function(input, numRows) {
  var rows = [];

  for (var i = 0; i < numRows; i += 1) {
    rows[i] = '';
  }

  var pos = 0, currRow = 0, dir = 1;
  while (pos < input.length) {
    rows[currRow] += input[pos++];
    currRow += dir;
    if (currRow === numRows) {
      dir = -1;
      currRow -= 2;
    }
    else if (currRow === (-1)) {
      dir = 1;
      currRow += 2;
    }
  }

  return rows
    .join('');
};

uUnit.run({
  'it works': function(assert) {
    assert.equal('PAHNAPLSIIGYIR', zigZag('PAYPALISHIRING'));
  }
});
