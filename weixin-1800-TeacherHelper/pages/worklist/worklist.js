const api = require('../../api.js');

Page({

  data: {
    homeworks: {},
    hasvalue: true
  },

  onLoad: function (options) {
    var that = this
    var homeworks = options.homeworks
    if(homeworks.length == 0){
      that.setData({
        hasvalue: false
      })
    }else {
      that.setData({
        homeworks: homeworks
      })
    }
  },

  onReady: function () {

  },

  onShow: function () {

  },

  onHide: function () {

  },

  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})