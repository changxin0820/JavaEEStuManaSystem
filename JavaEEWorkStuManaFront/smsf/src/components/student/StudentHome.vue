<template>
  <el-container class="home-container">
      <!--头部区-->
      <el-header height="80px">
        <div id="h2">
          <img src="./../../assets/picture/logo.png" alt="">
          <span id="h3">学生信息系统</span>
        </div>
        <el-button type="info" @click="logout">退出</el-button>
      </el-header>
      <!--页面主体区-->
      <el-container>
        <!--侧边栏-->
        <el-aside :width="isCollapse ? '64px':'200px'">
          <!--侧边栏伸缩-->
          <div class="toggle-button" @click="toggleCollapse">|||</div>
          <!--侧边栏菜单区域-->
          <el-menu id ="aside-ment" background-color="#6B91B6" ext-color="#6B91B6"
                   active-text-color="#FFBB62" unique-opened :collapse="isCollapse" :collapse-transition="isCollapse"
                   router >

            <!--一级菜单2-->
            <el-submenu :index="submenu.index" v-for="submenu in menulist" > <template slot="title"> <i class="el-icon-menu"></i> <span>{{ submenu.authName }}</span> </template>
              <!--二级目录项-->
              <el-menu-item :index="item.index" v-for="item in submenu.children" > {{ item.authName }} </el-menu-item>
            </el-submenu>

          </el-menu>
        </el-aside>
        <!--右侧内容主体-->
        <el-main>
          <!--路由占位符-->
          <router-view :id="id"></router-view>
        </el-main>
      </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "Home",


        data(){
            return{

                id:'',
                menulist:[
                    {authName:'我的课程',index:'/course',children:[{authName:'查看课程表',index:'/MineCourse'},
                                                              {authName:'选课',index:'SelectCourse'}
                                              ]
                    },
                    {authName:'我的成绩',index:'/performance',children:[{authName:'查询成绩',index:'/QueryPerformance'}
                                              ]
                    },
                    {authName:'我的信息',index:'/information',children:[{authName:'查看我的个人信息',index:'/StudentInfo'}
                                               ]
                    },
                    {authName:'帐号与安全',index:'/Security',children:[{authName:'修改密码',index:'/UpdatePass'}
                        ]
                    },
                ],
                //是否折叠
                isCollapse:false
            }
        },


      created() {

        this.id=this.$route.query.id;

      },
      methods:{

          initValue(){
            this.$router.onReady(() => {
                if(this.$route.query.id != undefined && this.$route.query.id != null)
                {


                  console.log("ss");
                  console.log(this.id);
                }

          })
          },
          PassValue(val){

            this.$router.push({
              path:'val',
              query:{
                id:this.id,

              }
            })
          },
            //点击按钮，切换菜单的折叠和展开
            toggleCollapse(){
                this.isCollapse = !this.isCollapse
            },
            //退出登录
            logout(){
                var global = this;
                this.$axios.get('/api/logout')
                    .then(function (response) {
                        var res = eval(response);
                        if(res.data.meta.success===true){
                            window.sessionStorage.clear();
                            global.$router.push("/")
                            return global.$message.success("安全退出!")
                        }
                })
                    .catch(function (error) {
                    console.log(error)
                })

            }
    }

    }
</script>
<style scoped>
  .home-container{
    height:100%;
    width: 100%;
  }
.el-header{
  background-color: #6B91B6;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: #ffffff;
  font-size: 40px;
}
  #h2{
    display: flex;
    align-items: center;
  }
  #h3{
    margin-left: 300px;
  }


  .el-aside{
    background-color:#6B91B6;
  }
  #aside-ment{
    border-right: none;
  }
  .el-main{
    background-color: #EAEDF1;
  }
  .toggle-button{
    background-color: #6B91B6;
    font-size: 10px;
    line-height: 24px;
    color: #ffffff;
    text-align: center;
    letter-spacing: 0.2em;
    cursor: pointer;
  }
</style>

107,145,182
