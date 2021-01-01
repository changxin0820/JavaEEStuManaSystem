<template>
  <div>
    <!--面包屑导航区域-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/Welcome' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>我的课程</el-breadcrumb-item>
      <el-breadcrumb-item>选课</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card style="width: 100%;">
      <el-table
        :data="courseData"
        border
        style="width: 100%">
        <el-table-column  prop="id" label="课程号" align="center" ></el-table-column>
        <el-table-column  prop="name" label="课程名称" align="center" ></el-table-column>
        <el-table-column  prop="credit" label="学分" align="center" ></el-table-column>
        <el-table-column :formatter="formatterStatus"  prop="status" label="课程性质" align="center" ></el-table-column>
        <el-table-column  prop="period" label="课时" align="center" ></el-table-column>
        <el-table-column  prop="time" label="上课时间" align="center" ></el-table-column>
        <el-table-column  prop="place" label="上课地点" align="center" ></el-table-column>
        <el-table-column  prop="teacher.name" label="教师" align="center" ></el-table-column>

        <el-table-column
          fixed="right"
          label="操作"
          align="center"
          width="100">
          <template slot-scope="scope">

            <el-button @click="selectCourse(scope.row)"    type="text" size="small" slot="reference">选课</el-button>

          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "SelectCourse",
  props:{id:"",},
  data(){
    return{
      courseData:[],

    }
  },
  created() {
    this.findAllCourse();
    console.log(this.id);
  },
  methods:{
    findAllCourse(){
      this.$axios.get('/api/course/findAllCourse').then(res=>{
        console.log(res);
        this.courseData=res.data;

      }).catch(error=>{

        this.$message.error(error);
      });
    },
    formatterStatus(row,colume){
      return row.status === 1 ? '必修' : '选修';
    },
    selectCourse(val){
      this.$confirm("是否选择这门课？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          //点击清零则将这一行的数据提交到数据库
          console.log(val);
          let that = this;
          this.$axios.post('/api/course/selectCourse',{
            sId:this.id,
            cId:val.id,
          }).then(res=>{
            console.log(res);
            if(res.data===true)
            {
              this.$message.success("选课成功");
            }
            else {
              this.$message.error("选课失败");
            }

          }).catch(error=>{

            this.$message.error(error);
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消选课"
          });
        });
    },
    deleteCourse(val){
      this.$confirm("该课程将要被删除, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          //点击清零则将这一行的数据提交到数据库
          console.log(val);
          let that = this;
          this.$axios.post('/api/course/deleteStudentCourse',{
            sId:this.studentId,
            cId:val.id,
          }).then(res=>{
            console.log(res);
            if(res.data===true)
            {
              this.$message.success("删除成功");
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

}
</script>

<style scoped>

</style>
