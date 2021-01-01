<template>
  <el-container class="home-container">
      <!--头部区-->
      <el-header height="80px">
        <div id="h2">
          <img src="./../../assets/picture/logo.png" alt="">
          <span id="h3">学生信息管理系统</span>
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
          <el-menu id ="aside-ment" background-color="#B7B7B7" ext-color="#ECDFF9"
                   active-text-color="#FFBB62" unique-opened :collapse="isCollapse" :collapse-transition="isCollapse"
                   router >

            <!--一级菜单2-->
            <el-submenu :index="submenu.index" v-for="submenu in menulist" > <template slot="title"> <i class="el-icon-menu"></i> <span>{{ submenu.authName }}</span> </template>
              <!--二级目录项-->
              <el-menu-item :index="item.index" v-for="item in submenu.children"> {{ item.authName }} </el-menu-item>
            </el-submenu>

          </el-menu>
        </el-aside>
        <!--右侧内容主体-->
        <el-main>
          <!--路由占位符-->
          <router-view :id="id" :studentId="studentId"></router-view>
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
              studentId:'',
                menulist:[
                    {authName:'课程管理',index:'/course',children:[{authName:'增加课程',index:'/NewCourse'},
                                                              {authName:'选项2',index:'/1-2'}
                                              ]
                    },
                    {authName:'学生成绩管理',index:'/performance',children:[{authName:'导入学生成绩',index:'/AddPerformance'},
                                                                    {authName:'查看学生成绩',index:'/2-2'}
                                              ]
                    },
                    {authName:'学生信息',index:'/information',children:[{authName:'学生信息管理',index:'/StudentInfoManagement'},

                                                                        {authName:'增加学生',index:'/StudentInsert'},
                                               ]
                    },
                  {authName:'学生登录管理',index:'/manage',children:[{authName:'启用禁用学生',index:'/UserManage'},

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
  background-color: #B7B7B7;
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
    background-color:#B7B7B7;
  }
  #aside-ment{
    border-right: none;
  }
  .el-main{
    background-color: #EAEDF1;
  }
  .toggle-button{
    background-color: #B7B7B7;
    font-size: 10px;
    line-height: 24px;
    color: #ffffff;
    text-align: center;
    letter-spacing: 0.2em;
    cursor: pointer;
  }
</style>
