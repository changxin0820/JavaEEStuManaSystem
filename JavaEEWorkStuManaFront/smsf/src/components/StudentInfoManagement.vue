<template>

  <el-container style=" height: 500px; width:100% ;border: 1px solid #efe0b0; border-radius: 12px">
    <el-header style="height: 80px">
      <div>
        <div style="text-align: center; font-size: 24px;color:#1d58bf">
          <span>学生信息管理</span>
        </div>

        <el-divider></el-divider>
        <el-divider></el-divider>
        <div style="text-align: center; font-size: 20px; font-weight:normal; color:#000000">
          <span>学籍管理</span>
        </div>
      </div>
    </el-header>
    <el-main>
      <el-row>
        <div style="text-align: left; font-size: 16px; font-weight:normal; height:30px; color:#000000">
          <span>学生信息查询:  </span>
        </div>
      </el-row>
      <el-row class="leftForm">
        <el-select class="formItem" v-model="queryMode" clearable placeholder="选择查询方式.." style="width: 150px">
          <el-option
            v-for="item in allQueryConditions"
            :key="item.id"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <el-input
          placeholder="请输入查询条件"
          v-model="queryCondition"
          style="width: 180px"
          clearable>
        </el-input>
        <el-button @click="queryStudentByCondition">
          查询
        </el-button>
      </el-row>
      <div>
        <el-card style="width: 100%;">
          <el-table
            :data="studentData"
            border
            style="width: 100%">
            <el-table-column  fixed="left" prop="id" label="学号" align="center" width="150"></el-table-column>
            <el-table-column  prop="name" label="姓名" align="center" width="150"></el-table-column>
            <el-table-column  prop="sex" label="性别" align="center" width="150"></el-table-column>
            <el-table-column  prop="idCard" label="身份证号" align="center" width="150"></el-table-column>
            <el-table-column  prop="nation" label="民族" align="center" width="150"></el-table-column>
            <el-table-column  prop="nativePlace" label="籍贯" align="center" width="150"></el-table-column>
            <el-table-column  prop="birth" label="出生日期" align="center" width="150"></el-table-column>
            <el-table-column  prop="politicsStatus" label="政治面貌" align="center" width="150"></el-table-column>
            <el-table-column  prop="academy.name" label="院系" align="center" width="150"></el-table-column>
            <el-table-column  prop="major.name" label="专业" align="center" width="150"></el-table-column>
            <el-table-column  prop="grade" label="年级" align="center" width="150"></el-table-column>
            <el-table-column  prop="phoneNum" label="电话号码" align="center" width="150"></el-table-column>
            <el-table-column
              fixed="right"
              align="center"
              label="操作"
              width="150">
              <template slot-scope="scope">
                <el-button @click="queryStudent(scope.row)" type="text" size="small">查看</el-button>
                <el-button @click="deleteStudent(scope.row)" type="text" size="small">删除</el-button>
                <el-button @click="updateStudent(scope.row)" type="text" size="small">更新</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </div>
      </el-main>
  </el-container>

</template>

<script>
  export default {
    name: "StudentInfoManagement",
    data(){
      return{

        queryMode:'',
        queryCondition:'',
        studentData:[
          {
            id:'',
            name:'',
            sex:'',
            idCard:'',
            nation:'',
            nativePlace:'',
            birth:'',
            politicsStatus:'',
            academy:{id:'', name:''},
            major:{id:'', name:''},
            grade:'',
            phoneNum:''
          }
        ],
        allQueryConditions: [
          { id:1,
            value: 1,
            label: '按学号查询',
          },
          {
            id:2,
            value: 2,
            label: '按专业查询',
          },
          {
            id:3,
            value: 3,
            label: '按院系查询',
          }
        ],
      }
    },
    methods:{

      updateStudent(val){

        this.$router.push({
          path:'/StudentUpdate',
          query:{
            id:val.id,
            name:val.name,
            sex:val.sex,
            idCard:val.idCard,
            nation:val.nation,
            nativePlace:val.nativePlace,
            birth:val.birth,
            politicsStatus:val.politicsStatus,
            academyName:val.academy.name,
            academyId:val.academyId,
            majorName:val.major.name,
            majorId:val.majorId,
            grade:val.grade,
            phoneNum:val.phoneNum
          }
        })


      },

      queryStudentByCondition(){

        if(this.queryMode===1){
          this.$axios.post('/api/studentInfo/findStudentById',{id:this.queryCondition}).then(res=>{
            console.log(res.data)
              this.studentData = res.data;
          }).catch(error=>{

            this.$message.error(error);
          });

        }else if(this.queryMode===2){
          this.majorName=this.queryCondition;
          this.$axios.post('/api/studentInfo/findStudentByMajorName',{majorName:this.majorName}).then(res=>{
            console.log(res);

            this.studentData=res.data;

          }).catch(error=>{

            this.$message.error(error);
          });


        }else if(this.queryMode===3){

          this.$axios.post('/api/studentInfo/findStudentByAcademyName',{academyName:this.queryCondition}).then(res=>{
            console.log(res);
            this.studentData=res.data;

          }).catch(error=>{

            this.$message.error(error);
          });

        }

      },
      queryStudent(val){

        this.$router.push({
          path:'/AStudentInfo',
          query:{
            id:val.id,

          }
        })
      },

      getAllStudent(){
        this.$axios.post('/api/studentInfo/findAll',).then(res=>{
          console.log(res);
          this.studentData=res.data;

        }).catch(error=>{

          this.$message.error(error);
        });
      },
      deleteStudent(val){
        this.$confirm("该学生将要被删除, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        })
          .then(() => {
            //点击清零则将这一行的数据提交到数据库
            console.log("ss");
            console.log(val);
            this.$axios.post('/api/studentInfo/deleteStudentInfo',{
              id:val.id,
            }).then(res=>{
              console.log(res);
              if(res.data===true)
              {
                this.$message.success("删除成功");
                this.getAllStudent();
              }
              else {
                this.$message.error("删除失败");
              }

            }).catch(error=>{

              this.$message.error(error);
            });
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消删除"
            });
          });

      }
    },
    created() {
      this.getAllStudent();
    }
  }
</script>

<style scoped>
  .el-divider{
    margin: 5px 0;
    background: 0 0;
    border-top: 1px solid #000000;
  }
  .leftForm {
    float: left;
    height: 50px;
  }
</style>

