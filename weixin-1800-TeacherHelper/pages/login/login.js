//获取应用实例
const app = getApp()
const api = require('../../api.js');

Page({

  data: {
    ifhidden: true,
    name: '',
    userid:''
  },

  next: function() {
    var name = this.data.name
    if(name == ''){
      wx.showToast({
        title: '姓名不能为空',
        icon: 'none'
      })
    }else{
      this.setData({
        ifhidden: false
      })
    }
  },

  prev: function () {
    this.setData({
      ifhidden: true
    })
  },

  iname:function(e) {
    this.setData({
      name: e.detail.value
    })
  },

  getUserInfo: function (e) {
    wx.showLoading({
      title: '正在登录',
    })
    var that = this
    wx.setStorage({
      key: 'userInfo',
      data: e.detail.userInfo,
      success:function() {
        app.globalData.userInfo = e.detail.userInfo
        var userInfo = e.detail.userInfo
        var avatarUrl = userInfo.avatarUrl;
        var city = userInfo.city;
        var country = userInfo.country;
        var gender = userInfo.gender;
        var language = userInfo.language;
        var nickName = userInfo.nickName;
        nickName = encodeURIComponent(nickName);
        nickName = encodeURIComponent(nickName);//二次编码
        var province = userInfo.province;
        var name = that.data.name
        name = encodeURIComponent(name);
        name = encodeURIComponent(name);//二次编码
        wx.getStorage({
          key: 'code',                                               //code
          success: function (res) {
            wx.request({
              url: api.ip + 'handle/adduser',
              data: {
                code: res.data,
              },
              header: { 'content-type': 'application/json' },
              success: function (res) {
                var userOpenid = res.data.openid;                       //openid
                wx.setStorage({//存储到本地
                  key: "userOpenid",
                  data: userOpenid,
                  success: function () {
                    wx.request({
                      method: 'GET',
                      url: api.ip + 'operateuser/inserforumuser?openid=' + userOpenid + '&avatarUrl=' + avatarUrl + '&city=' + city + '&country=' + country + '&gender=' + gender + '&language=' + language + '&nickName=' + nickName + '&province=' + province + '&con2=' + name,
                      success: function (res) {
                        var userid = res.data.userid;
                        name = res.data.name
                        if (userid == null) {
                          var toastText = '获取数据失败' + res.data.errMsg;
                          wx.showToast({
                            title: toastText,
                            icon: '',
                            duration: 2000 //弹出时间
                          })
                        } else {
                          that.setData({
                            userid: userid,
                          });
                          wx.setStorage({
                            key: 'userid',
                            data: userid,
                            success: function () {
                              wx.setStorage({
                                key: 'userName',
                                data: name,
                                success: function () {
                                  wx.setStorage({
                                    key: 'hasUserInfo',
                                    data: true,
                                    success: function () {
                                      setTimeout(function () {
                                        wx.showToast({
                                          title: '登录成功',
                                          success: function () {
                                            setTimeout(function () {
                                              wx.switchTab({
                                                url: '../index/index',
                                              })
                                            }, 1000)
                                          },
                                          fail: function () {
                                            wx.hideLoading()
                                          }
                                        })
                                      }, 1500)
                                    },
                                    fail: function () {
                                      wx.hideLoading()
                                    }
                                  })
                                },
                                fail: function () {
                                  wx.hideLoading()
                                }
                              })
                            },
                            fail: function () {
                              wx.hideLoading()
                            }
                          })
                        }
                      },
                      fail: function () {
                        wx.showToast({
                          title: '登录失败',
                          icon: 'none',
                          duration: 500,
                        })
                      }
                    })
                  },
                  fail: function () {
                    wx.hideLoading()
                  }
                })
              },
              fail: function () {
                wx.showToast({
                  title: '登录失败',
                  icon: 'none',
                  duration: 500,
                })
              }
            })
          },
          fail: function () {
            wx.showToast({
              title: '登录失败',
              icon: 'none',
              duration: 500,
            })
          }
        })
      },
      fail: function () {
        wx.showToast({
          title: '登录失败',
          icon: 'none',
          duration: 500,
        })
      }
    })
  },

  onLoad: function (options) {
    
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