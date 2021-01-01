<template>
  <div>

    <el-table :data="users" style="width: 100%">
      <el-table-column prop="id" label="学号ID"></el-table-column>
      <el-table-column prop="name" label="姓名"></el-table-column>
      <el-table-column prop="idCard" label="身份证号"></el-table-column>
      <el-table-column prop="sex" label="性别"></el-table-column>
      <el-table-column prop="status" label="状态"></el-table-column>
      <el-table-column prop="grade" label="年级"></el-table-column>
      <el-table-column label="禁用用户">
        <template slot-scope="scope">

          <el-button
            type="success"
            value="return"
            @click="enable(scope.row)"
          >启用</el-button>
          <el-button
            type="danger"
            value="return"

            @click="disable(scope.row)"
          >禁用</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>


<style scoped>
  .el-row {
    margin: 50px 0;
  }
  .publish {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both;
  }
</style>


<script>
  export default {
    name: "UserManage",
    data() {
      return {
        users: []
      };
    },
    methods: {
      getAllUsers: function () {
        this.$axios.get('/api/getAllUsers',{})
          .then(res => {
            console.log(res);
            if (res.data.meta.success === true) {
              this.users = res.data.data;
              this.users.forEach(e => {
                e.status = e.status === 1 ? "正常" : "被禁用";
              });
            }

          }).catch(error => {
          this.$message({
            message: "获取失败！",
            type: "error"
          });
        })
      },

      enable(user) {
        this.$axios.get('api/enableUser', {
          params: {id: user.id}
        })
          .then(
            res => {
              if (res.data.meta.success === true) {
                this.getAllUsers();
              }
            }).catch(error=> {
              this.$message({
              showClose: true,
              message: "错误",
              type: "error"
          });
        }),
          function () {
            console.log("请求失败处理");
          }
      },
      disable(user) {
        this.$axios.get('api/disableUser', {
          params: {id: user.id}
        })
          .then(
            res => {
              if (res.data.meta.success === true) {
                this.getAllUsers();
              }
            }).catch(error => {
          this.$message({
            message: "获取失败！",
            type: "error"
          });
      }),
            function () {
              console.log("请求失败处理");
            }
      },
    },
    created() {
      this.getAllUsers();
    }
  };

</script>
