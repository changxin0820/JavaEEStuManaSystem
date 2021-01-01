<template>
  <div>
    <el-button @click="sendmessage">
     sss{{msg}}
    </el-button>
    <el-button @click="changeToStudentInfo">
     跳转学生信息
    </el-button>
    <el-button @click="changeToStudentManagement">
      跳转插入学生
    </el-button>
    <el-button @click="changeToStudentInfoManagement">
      跳转学生管理
    </el-button>
    <el-button @click="changeToUserManage">
      用户管理
    </el-button>
    <el-button @click="changeTonewCourse">
      新增课程
    </el-button>
    <el-button @click="changeToMineCourse">
      我的课程
    </el-button>
    <el-button @click="changeToselectCourse">
      选课
    </el-button>

  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: '',
      user:{}
    }
  },
  methods:{
    sendmessage () {
      this.$axios.get('/api/account/findAll', ).then(res => {
        this.msg = res.data;

      })
    },
    changeToStudentInfo(){
      this.$router.push('/StudentInfo');
    },
    changeToStudentManagement(){
      this.$router.push('/StudentInsert');
    },
    changeToStudentInfoManagement(){
      this.$router.push('/StudentInfoManagement');
    }
  },
    changeToUpdatePass(){
      this.$router.push('/UpdatePass');
    },
    changeToUserManage(){
      this.$router.push('/UserManage');
    },
    changeToMineCourse(){
      this.$router.push('/MineCourse');
    },
    logout: function(){

      this.$axios.get('api/logout').then(res =>{
        if (res.data.meta.success === true) {
          this.$store.commit("userLogout");
          this.user = {};
          this.$message({
            showClose: true,
            message: "退出登录成功",
            type: "success",
            duration: 1000
          });
          this.$router.push({
            //你需要接受路由的参数再跳转
            path: "/Login"
          });
        } else {
          this.$message({
            showClose: true,
            message: res.data.meta.message,
            type: "error"
          });
        }
      }).catch(error=>{
        this.$message({
          showClose: true,
          message: "注销失败！",
          type: "error"
        });
      })

    },
    changeTonewCourse(){
      this.$router.push('/newCourse');

    },
    changeToselectCourse(){
      this.$router.push('/SelectCourse');
    },

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
