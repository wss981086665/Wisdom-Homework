// pages/answer-detail/answer-detail.js
Page({

  data: {
    answer:'',
    imgurl:'',
    hasimage: false
  },

  previewImage: function (e) {
    var articles = [e.currentTarget.dataset.src];
    wx.previewImage({
      urls: articles
    })
  },

  onLoad: function (options) {
    var that = this
    var imgurl = ''
    wx.getStorage({
      key: 'answer',
      success: function(res) {
        var answer = res.data
        if(answer.imgurl != ''){
          that.setData({
            hasimage: true,
          })
          imgurl = 'http://www.xztywss.top/img/homeworkup/' + res.data.imgurl
        }
        setTimeout(function () {
          that.setData({
            answer: answer,
            imgurl: imgurl
          })
        }, 600)
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

  onPullDownRefresh: function () {

  },

  onReachBottom: function () {

  },

  onShareAppMessage: function () {

  }
})