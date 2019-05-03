//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: true,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
  },

  goSearch: function() {
    wx.navigateTo({
      url: '../search/search',
    })
  },

  toMyhomework:function() {
    wx.navigateTo({
      url: '../myhomework/myhomework',
    })
  },

  toPasswork:function() {
    wx.navigateTo({
      url: '../passwork/passwork',
    })
  },

  toCreakwork:function() {
    wx.navigateTo({
      url: '../creatwork/creatwork',
    })
  },

  toMyclass:function() {
    wx.navigateTo({
      url: '../myclass/myclass',
    })
  },

  onLoad: function () {
    
  },
  onReady:function() {

  },
  onShow: function() {
    var that = this;
    wx.getStorage({
      key: 'hasUserInfo',
      success: function (res) {
        if (res.data == false) {
          wx.navigateTo({
            url: '../login/login',
          })
        }
      },
      fail: function () {
        that.setData({
          hasUserInfo: false
        })
        wx.setStorage({
          key: 'hasUserInfo',
          data: false,
          success:function() {
            wx.navigateTo({
              url: '../login/login',
            })
          }
        })
      }
    })
  },

})
