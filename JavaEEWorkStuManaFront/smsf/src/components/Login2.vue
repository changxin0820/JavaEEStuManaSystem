<template>
<div>
  <!--头部-->
  <div class="header" id="head">
    <div class="title">学生信息系统</div>
  </div>
  <!--登录表单-->
  <div class="wrap" id="wrap">
    <div class="logGet">
      <!-- 头部提示信息 -->
      <div class="logD logDtip">
        <p class="p1">登录</p>
      </div>
      <!-- 用户名 -->
      <div class="lgD">
        <input type="text" placeholder="输入帐号" v-model="Id">
      </div>
      <!-- 密码 -->
      <div class="lgD">
        <input type="text" placeholder="输入密码" v-model="password"/>
      </div>
      <div class="logC">
        <el-button type="primary"  @click="login" >登录</el-button>
      </div>
    </div>
  </div>

</div>
</template>

<!--js-->
<script>
    export default {
        name: "Login",
        data () {
            return {
                Id:'',
                password:''
            }
        },
        methods:{
            //登录，携带用户的信息请求
            login() {
                var global = this;
                this.$axios.post(
                    '/api/login',
                    this.$qs.stringify({
                        id:this.Id
                    })
                ).then( response=>{
                    console.log(response)
                    if(response.status!=200)
                        return global.$message.info("服务器正在维修中......");
                    var res = eval(response);
                    if(res.data==="")
                        return global.$message.error("帐号错误，请重新输入")
                    if(global.password===res.data.password){
                        if(res.data.status===1){
                            if(res.data.type===1){
                                window.sessionStorage.setItem("token","tokkk");
                              this.$router.push({
                                path:'/StudentHome',
                                query:{
                                  id:response.data.id,

                                }
                              })
                                return global.$message.success("欢迎同学使用信息系统")
                            }
                            else{
                                window.sessionStorage.setItem("token","tokkk");
                                global.$router.push(
                              {
                                path:"/TeacherHome",
                                  query:{
                                id:response.data.id,

                              }
                              })
                                return global.$message.success("欢迎老师使用信息管理系统")
                            }
                        }
                        else
                            return global.$message.warning("帐号异常，请前往解封")
                    }
                    else
                        return global.$message.error("密码错误，请重新输入")


                }).catch(function (error) {
                        console.log(error)
                    })
            }
        },
    }
</script>

<!--css-->
<style scoped>
  #head {
    height: 100px;
    background-color: #6B91B6;
    text-align: center;
    position: relative;
  }
  #wrap {
    height: 200px;
    position: relative;
  }
  #wrap .logGet {
    height: 408px;
    width: 368px;
    position: absolute;
    background-color: #FFFFFF;
    top: 20%;
    right: 15%;
  }

  .logC a button {
    width: 100%;
    height: 45px;
    background-color: #ee7700;
    border: none;
    color: white;
    font-size: 18px;
  }
  .logGet .logD.logDtip .p1 {
    display: inline-block;
    font-size: 28px;
    margin-top: 0px;
    width: 86%;
  }
  #wrap .logGet .logD.logDtip {
    width: 86%;
    border-bottom: 1px solid #ee7700;
    margin-bottom: 60px;
    margin-top: 0px;
    margin-right: auto;
    margin-left: auto;
  }
  .logGet .lgD img {
    position: absolute;
    top: 12px;
    left: 8px;
  }
  .logGet .lgD input {
    width: 100%;
    height: 42px;
    text-indent: 2.5rem;
  }
  #wrap .logGet .lgD {
    width: 86%;
    position: relative;
    margin-bottom: 30px;
    margin-top: 30px;
    margin-right: auto;
    margin-left: auto;
  }
  #wrap .logGet .logC {
    width: 86%;
    margin-top: 0px;
    margin-right: auto;
    margin-bottom: 0px;
    margin-left: auto;
  }


  .title {
    font-family: "宋体";
    color: #FFFFFF;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
    font-size: 36px;
    height: 40px;
    width: 30%;
  }

</style>
