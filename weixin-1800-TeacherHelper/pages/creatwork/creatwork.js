const app = getApp()
const api = require('../../api.js');
const util = require('../../utils/util.js');

Page({

  data: {
    images: [],
    worktip: '',
    workcon: '',
    classnames:[],
    classids:[],
    classname:'未选择',
    classvalue: -1
  },

  addphoto: function (e) {
    var that = this;
    wx.chooseImage({
      count: 2,
      sizeType: ['compressed'],  //可选择原图或压缩后的图片
      sourceType: ['album', 'camera'], //可选择性开放访问相册、相机
      success: function (res) {
        const images = that.data.images.concat(res.tempFilePaths)
        that.setData({
          images: images.length <= 2 ? images : images.slice(0, 2)
        })
      },
      fail:function() {
        wx.showToast({
          title: '添加图片失败',
          icon: 'none',
          duration:500
        })
      }
    })
  },

  inputtip: function (e) {
    var that = this
    that.setData({
      worktip: e.detail.value
    })
  },
  inputcon: function (e) {
    var that = this
    that.setData({
      workcon: e.detail.value
    })
  },

  bindPickerChange:function(e) {
    this.setData({
      classvalue: e.detail.value,
      classname: this.data.classnames[e.detail.value]
    })
  },

  worksubmit:function() {
    var userInfo = {}
    var that = this;
    var classvalue = that.data.classvalue
    wx.getStorage({
      key: 'userInfo',
      success: function(res) {
        userInfo = res.data
        var code = ''
        var imgurl = ''
        var openid = ''
        var topic = that.data.worktip
        var content = that.data.workcon
        var date = util.formatData(new Date())
        var author = ''
        var nickName = userInfo.nickName
        var avatarUrl = userInfo.avatarUrl
        var classid = classvalue > 0 ? that.data.classids[classvalue] : "default"
        console.log(classid)

        topic = encodeURIComponent(topic);
        topic = encodeURIComponent(topic);//二次编码
        content = encodeURIComponent(content);
        content = encodeURIComponent(content);//二次编码
        author = encodeURIComponent(author);
        author = encodeURIComponent(author);//二次编码
        nickName = encodeURIComponent(nickName);
        nickName = encodeURIComponent(nickName);//二次编码
        var images = that.data.images
        var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        for (var i = 0; i < 4; i++) {
          var index = Math.floor(Math.random() * 36);
          code += random[index];
        }
        if(images.length > 0){
          wx.showLoading({
            title: '正在上传图片',
          })
          wx.uploadFile({
            url: api.ip + 'handle/uploadfile',
            filePath: images[0],
            name: 'file',
            header: {
              'content-type': 'multipart/form-data'
            }, // 设置请求的 header
            success: function (res) {
              imgurl += res.data
              if(images.length == 2){
                wx.uploadFile({
                  url: api.ip + 'handle/uploadfile',
                  filePath: images[1],
                  name: 'file',
                  header: {
                    'content-type': 'multipart/form-data'
                  }, // 设置请求的 header
                  success: function (res) {
                    imgurl = imgurl + '/' + res.data
                    wx.getStorage({
                      key: 'userOpenid',
                      success: function (res) {
                        openid = res.data
                        wx.getStorage({
                          key: 'userName',
                          success: function (res) {
                            author = res.data
                            wx.request({
                              method: 'POST',
                              url: api.ip + "homework/inserthomework?code=" + code + "&imgurl=" + imgurl + "&openid=" + openid + "&topic=" + topic + "&content=" + content + "&date=" + date + "&author=" + author + "&nickName=" + nickName + "&avatarUrl=" + avatarUrl +"&factor1=" + classid,
                              success: function () {
                                wx.showToast({
                                  title: '发布成功',
                                  success: function () {
                                    setTimeout(function () {
                                      wx.navigateTo({
                                        url: '../codedisplay/codedisplay?code=' + code,
                                      })
                                    }, 1000)
                                  }
                                })
                              },
                              fail: function () {
                                wx.showToast({
                                  title: '上传失败',
                                  icon: 'none',
                                  duration: 500
                                })
                              }
                            })
                          }
                        })
                      }
                    })
                  },
                  fail: function () {
                    wx.showToast({
                      title: '上传图片失败',
                      icon: 'none',
                      duration: 500
                    })
                  }
                })
              }else {
                wx.getStorage({
                  key: 'userOpenid',
                  success: function (res) {
                    openid = res.data
                    wx.getStorage({
                      key: 'userName',
                      success: function (res) {
                        author = res.data
                        wx.request({
                          method: 'POST',
                          url: api.ip + "homework/inserthomework?code=" + code + "&imgurl=" + imgurl + "&openid=" + openid + "&topic=" + topic + "&content=" + content + "&date=" + date + "&author=" + author + "&nickName=" + nickName + "&avatarUrl=" + avatarUrl + "&factor1=" + classid,
                          success: function () {
                            wx.showToast({
                              title: '发布成功',
                              success: function () {
                                setTimeout(function () {
                                  wx.navigateTo({
                                    url: '../codedisplay/codedisplay?code=' + code,
                                  })
                                }, 1000)
                              }
                            })
                          },
                          fail: function () {
                            wx.showToast({
                              title: '上传失败',
                              icon: 'none',
                              duration: 500
                            })
                          }
                        })
                      }
                    })
                  }
                })
              }
            },
            fail: function () {
              wx.showToast({
                title: '上传图片失败',
                icon: 'none',
                duration: 500
              })
            }
          })
        }else {
          wx.showLoading({
            title: '正在上传',
          })
          wx.getStorage({
            key: 'userOpenid',
            success: function (res) {
              openid = res.data
              wx.getStorage({
                key: 'userName',
                success: function (res) {
                  author = res.data
                  wx.request({
                    method: 'POST',
                    url: api.ip + "homework/inserthomework?code=" + code + "&imgurl=" + imgurl + "&openid=" + openid + "&topic=" + topic + "&content=" + content + "&date=" + date + "&author=" + author + "&nickName=" + nickName + "&avatarUrl=" + avatarUrl + "&factor1=" + classid,
                    success: function () {
                      setTimeout(function() {
                        wx.showToast({
                          title: '发布成功',
                          success: function () {
                            setTimeout(function () {
                              wx.navigateTo({
                                url: '../codedisplay/codedisplay?code=' + code,
                              })
                            }, 1000)
                          }
                        })
                      },500)
                    },
                    fail: function () {
                      wx.showToast({
                        title: '上传失败',
                        icon: 'none',
                        duration: 500
                      })
                    }
                  })
                }
              })
            }
          })
        }
      },
    })
  },

  onLoad: function (options) {
    var that = this
    wx.getStorage({
      key: 'userOpenid',
      success: function(res) {
        wx.request({
          method: 'GET',
          url: api.ip + "democlass/getclassinfo?openid=" + res.data,
          success:function(res) {
            var classnames = res.data.classnames;
            var classids = res.data.classids
            if (classnames == null) {
              var toastText = '获取数据失败' + res.data.errMsg;
              wx.showToast({
                title: toastText,
                icon: '',
                duration: 2000 //弹出时间
              })
            } else {
              that.setData({
                classnames: classnames,
                classids: classids
              })
            }
          }
        })
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