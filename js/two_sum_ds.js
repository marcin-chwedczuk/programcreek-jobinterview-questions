var uUnit = require('./uUnit');

var TwoSum = function TwoSum() {
  this.numbers = [];
  this.sorted = false;
};

TwoSum.prototype.add = function(n) {
  this.numbers.push(n);
  this.sorted = false;

  return this;
};

TwoSum.prototype.find = function(sum) {
  this._sort();
  return this._twoSumExists(sum);
};

TwoSum.prototype._sort = function() {
  if (!this.$sorted) {
    this.$sorted = true;

    this.numbers.sort(function(l, r) {
      return (l-r);
    });
  }
};

TwoSum.prototype._twoSumExists = function(sum) {
  var array = this.numbers;
  var pmin = 0, pmax = array.length-1;

  while (pmin < pmax) {
    var currSum = array[pmin] + array[pmax];

    if (currSum === sum)
      return true;
    else if (currSum < sum)
      pmin += 1;
    else // (currSum > sum)
      pmax -= 1;
  }

  return false;
};

uUnit.run({
  'test TwoSum data structure': function(assert) {
    var ts = new TwoSum();
    ts.add(1).add(3).add(5);

    assert.true(ts.find(4));
    assert.false(ts.find(7));
  }
});
