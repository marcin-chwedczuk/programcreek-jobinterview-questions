
var iv = exports.iv = function(start, stop) {
  return {
    start:start,
    stop:stop,

    contains: function(point) {
      return this.start <= point && point < this.stop;
    },

    overlaps: function(interval) {
      return this.contains(interval.start) ||
             this.contains(interval.stop)  ||
             interval.contains(this.start);
    },

    merge: function(interval) {
      return iv(Math.min(this.start, interval.start),
                Math.max(this.stop, interval.stop));
    },

    toString: function() {
      return '(' + this.start + ', ' + this.stop + ')';
    }
  };
};

exports.INTERVAL_EQUALITY = function(leftIv, rightIv) {
  if (leftIv === null && rightIv === null)
    return true;

  if (leftIv === null || rightIv === null)
    return false;

  return (leftIv.start === rightIv.start) && (leftIv.stop === rightIv.stop);
};
