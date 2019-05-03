const api = require('../../api.js');

Page({

  data: {
    homework: {},
    images: [],
    hasimage: false
  },

  previewImage: function (e) {
    var articles = [e.currentTarget.dataset.src];
    wx.previewImage({
      urls: articles
    })
  },

  rowrite:function() {
    wx.navigateTo({
      url: '../replywork/replywork',
    })
  },

  onLoad: function (options) {
    var that = this;
    wx.getStorage({
      key: 'homework',
      success: function(res) {
        var homework = res.data
        var images = ''
        if(homework.imgurl != ''){
          that.setData({
            hasimage: true
          })
          images = homework.imgurl.split('/')
          for (var i = 0; i < images.length; i++) {
            images[i] = 'http://www.xztywss.top/img/homeworkup/' + images[i]
          }
        }
        setTimeout(function() {
          that.setData({
            homework: homework,
            images: images
          })
        },600)
      },
    })
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