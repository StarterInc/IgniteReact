'use strict';

Object.defineProperty(exports, "__esModule", {
  value: true
});

var _react = require('react');

var _react2 = _interopRequireDefault(_react);

var _pure = require('recompose/pure');

var _pure2 = _interopRequireDefault(_pure);

var _svgIcon = require('../../svg-icon');

var _svgIcon2 = _interopRequireDefault(_svgIcon);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

var AvFiberSmartRecord = function AvFiberSmartRecord(props) {
  return _react2.default.createElement(
    _svgIcon2.default,
    props,
    _react2.default.createElement(
      'g',
      null,
      _react2.default.createElement('circle', { cx: '9', cy: '12', r: '8' }),
      _react2.default.createElement('path', { d: 'M17 4.26v2.09c2.33.82 4 3.04 4 5.65s-1.67 4.83-4 5.65v2.09c3.45-.89 6-4.01 6-7.74s-2.55-6.85-6-7.74z' })
    )
  );
};
AvFiberSmartRecord = (0, _pure2.default)(AvFiberSmartRecord);
AvFiberSmartRecord.displayName = 'AvFiberSmartRecord';

exports.default = AvFiberSmartRecord;
module.exports = exports['default'];