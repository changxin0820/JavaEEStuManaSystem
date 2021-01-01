<template>
  <div>
    <!--面包屑导航区域-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/Welcome' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>帐号与安全</el-breadcrumb-item>
      <el-breadcrumb-item>修改密码</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="updatePassContainer">
      <el-form :model="ruleForm" ref="ruleForm" label-width="100px" :rules="rules">
        <el-form-item label="原密码" prop="oldPass">
          <el-input
            type="password"
            placeholder="原密码"
            name="oldPass"
            v-model="ruleForm.oldPass"
            show-password
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label="新密码" prop="newPass">
          <el-input
            type="password"
            placeholder="密码"
            name="newPass"
            v-model="ruleForm.newPass"
            show-password
            clearable
          ></el-input>
        </el-form-item>
        <el-form-item label=" 注意：每次修改密码成功后需要重新登录" label-width="300px" prop="oldPass">

        </el-form-item>

        <el-form-item>
          <el-button type="primary" value="update" @click="update" :loading="isloading">确认</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script>
export default {
  name: "UpdatePass",
  props:{id:""},
  data() {
    return {
      isloading: false,
      ruleForm: {
        id:"",

        oldPass: "",
        newPass: ""
      },
      rules: {
        id: [{required:false,message:"请输入要修改密码的学号",trigger:"blur"}],
        oldPass: [{ required: true, message: "请输入原密码", trigger: "blur" }],
        newPass: [{ required: true, message: "请输入新密码", trigger: "blur" }]
      }
    };
  },
  methods: {

    update() {
      this.isloading=true;
      this.$axios.post('/api/updatePass',{
        id: this.id,
        oldPass: this.ruleForm.oldPass,
        newPass: this.ruleForm.newPass
      }).then(res=>{
        //console.log(res);调试
        this.isloading=false;

        if (res.data.meta.success === true) {
          this.$message({
            showClose: true,
            message: "修改成功,请重新登录！",
            type: "success",
            duration: 1000
          });

          setTimeout(() => {
            //跳转
            this.$router.push({
              path: "/"
            });
          }, 1000);
        }
        else {
          this.$message({
            showClose: true,
            message: res.data.meta.message,
            type: "error",
          });
        }
      }).catch(error=>{
        this.$message({
          showClose: true,
          message: "修改失败！",
          type: "error"
        });

      })
    },
  }
};
</script>
<style scoped>
.el-form {
  width: 360px;
  text-align: left;
}

.updatePassContainer {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}


</style>
