// pages/replywork/replywork.js
const util = require('../../utils/util.js');
const api = require('../../api.js');
Page({

  data: {
    homework: {},
    images: [],
    replycon:'',
    userInfo: {},
    userName:'',
    openid:''
  },

  addphoto: function (e) {
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['compressed'],  //可选择原图或压缩后的图片
      sourceType: ['album', 'camera'], //可选择性开放访问相册、相机
      success: function (res) {
        const images = that.data.images.concat(res.tempFilePaths)
        that.setData({
          images: images.length <= 1 ? images : images.slice(0, 1)
        })
      },
      fail:function() {
        wx.showToast({
          title: '添加图片失败',
          icon: 'none',
          duration: 500,
        })
      }
    })
  },

  inputcon: function (e) {
    var that = this
    that.setData({
      replycon: e.detail.value
    })
  },

  submitreply:function() {
    var that = this
    var images = that.data.images

    wx.showModal({
      title: '温馨提示',
      content: '确定要提交吗？',
      confirmColor: '#32CD32',
      confirmText: '提交',
      success: function (res) {
        if (res.confirm) {
          var homework = that.data.homework
          var code = homework.code
          var codeid = homework.code + homework.id
          var imgurl = ''
          var openid = that.data.openid
          var content = that.data.replycon
          var date = util.formatData(new Date())
          var author = that.data.userName
          var nickName = that.data.userInfo.nickName
          var avatarUrl = that.data.userInfo.avatarUrl
          content = encodeURIComponent(content);
          content = encodeURIComponent(content);//二次编码
          author = encodeURIComponent(author);
          author = encodeURIComponent(author);//二次编码
          nickName = encodeURIComponent(nickName);
          nickName = encodeURIComponent(nickName);//二次编码
          if (images.length > 0) {
            wx.showLoading({
              title: '正在提交',
            })
            wx.uploadFile({
              url: api.ip + 'handle/uploadfile',
              filePath: images[0],
              name: 'file',
              header: {
                'content-type': 'multipart/form-data'
              }, // 设置请求的 header
              success: function (ress) {
                imgurl = imgurl + ress.data
                wx.request({
                  method: 'POST',
                  url: api.ip + 'reply/insertreply?code=' + code + '&codeid=' + codeid + '&imgurl=' + imgurl + '&openid=' + openid + '&content=' + content + '&date=' + date + '&author=' + author + '&nickName=' + nickName + '&avatarUrl=' + avatarUrl,
                  success: function () {
                    setTimeout(function () {
                      wx.showToast({
                        title: '提交成功',
                        success: function () {
                          setTimeout(function () {
                            wx.switchTab({
                              url: '../index/index'
                            })
                          }, 1000)
                        }
                      })
                    }, 500)
                  },
                  fail:function() {
                    wx.showToast({
                      title: '连接服务器失败',
                      icon: 'none',
                      duration: 500,
                    })
                  }
                })
              },
              fail:function() {
                wx.showToast({
                  title: '上传图片失败',
                  icon: 'none',
                  duration: 500,
                })
              }
            })
          } else {
            wx.showLoading({
              title: '正在提交',
            })
            wx.request({
              method: 'POST',
              url: api.ip + 'reply/insertreply?code=' + code + '&codeid=' + codeid + '&imgurl=' + imgurl + '&openid=' + openid + '&content=' + content + '&date=' + date + '&author=' + author + '&nickName=' + nickName + '&avatarUrl=' + avatarUrl,
              success: function () {
                setTimeout(function () {
                  wx.showToast({
                    title: '提交成功',
                    success: function () {
                      setTimeout(function () {
                        wx.switchTab({
                          url: '../index/index'
                        })
                      }, 1000)
                    }
                  })
                }, 500)
              }
            })
          }
        }
      }
    })
  },

  onLoad: function (options) {
    var that = this;
    wx.getStorage({
      key: 'homework',
      success: function (res) {
        wx.getStorage({
          key: 'userInfo',
          success: function(ress) {
            wx.getStorage({
              key: 'userName',
              success: function(resss) {
                wx.getStorage({
                  key: 'userOpenid',
                  success: function(resa) {
                    that.setData({
                      homework: res.data,
                      userInfo: ress.data,
                      userName: resss.data,
                      openid: resa.data
                    })
                  },
                })
              },
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