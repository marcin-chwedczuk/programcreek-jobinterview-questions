var uUnit = require('./uUnit');

var minPath = function(triangle) {
  var lens = [], tmp = [];

  var col, row;

  for (col = 0; col < triangle.length; col += 1) {
    lens[col] = T(0, col);
  }

  for (row = 1; row < triangle.length; row += 1) {
    for (col = 0; col < triangle.length - row; col += 1) {
      tmp[col] = T(row, col) + Math.min(lens[col], lens[col+1]);
    }

    var swap = tmp; tmp = lens; lens = swap;
  }

  return lens[0];

  function T(row, col) {
    // [last row]
    // ...
    // [0 th row] - [ 0th elem 1th elem ... nth elem ]
    return triangle[triangle.length-1 - row][col];
  }
};

uUnit.run({
  'triangle works': function(assert) {
    var actual = minPath([
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]);

    assert.equal(11, actual);
  }
});
