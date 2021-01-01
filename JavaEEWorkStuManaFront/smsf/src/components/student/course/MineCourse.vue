<template>
<div>
  <!--面包屑导航区域-->
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item :to="{ path: '/Welcome' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item>我的课程</el-breadcrumb-item>
    <el-breadcrumb-item>查看课程表</el-breadcrumb-item>
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

            <el-button @click="deleteCourse(scope.row)"    type="text" size="small" slot="reference">删除</el-button>

        </template>
      </el-table-column>
    </el-table>
  </el-card>
</div>
</template>

<script>
export default {
  name: "MineCourse",
  props:{
    id:"",
  },
  data(){
    return{
      courseData:[],

    }
  },
  methods:{
    getStudentCourse(){
      this.$axios.post('/api/course/findAllCourseByStudentId',{
        id:this.id
      }).then(res=>{
        console.log(res);
        this.courseData=res.data;

      }).catch(error=>{

        this.$message.error(
          {
            type:'error',
            message:"出现错误，请稍后再试"
          }

        );
        });
    },
    formatterStatus(row,colume){
      return row.status === 1 ? '必修' : '选修';
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
            sId:this.id,
            cId:val.id,
          }).then(res=>{
            console.log(res);
            if(res.data===true)
            {
              this.$message.success("删除成功");
              this.getStudentCourse();
            }
            else {
              this.$message.error("删除失败");
            }

          }).catch(error=>{

            this.$message.error(
              {
                type:'error',
                message:"出现错误，请稍后再试"
              }

            );
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
    console.log(this.id);
  },
  mounted() {

    this.getStudentCourse();
  },


}
</script>

<style scoped>

</style>
