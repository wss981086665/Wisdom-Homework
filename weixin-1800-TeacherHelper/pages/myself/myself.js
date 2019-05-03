//获取应用实例
const app = getApp()

Page({

  data: {
    userInfo: {},
    userName: ''
  },

  fun1:function() {
    wx.navigateTo({
      url: '../listwork/listwork',
    })
  },

  tocreat:function() {
    wx.navigateTo({
      url: '../creatclass-tip/creatclass-tip',
    })
  },

  applyteacher:function() {
    wx.navigateTo({
      url: '../apply-teacher/apply-teacher',
    })
  },

  onLoad: function (options) {
    var that = this;
    wx.getStorage({
      key: 'userInfo',
      success: function (res) {
        that.setData({
          userInfo: res.data
        })
        wx.getStorage({
          key: 'userName',
          success: function(ress) {
            that.setData({
              userName: ress.data
            })
          },
        })
      }
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