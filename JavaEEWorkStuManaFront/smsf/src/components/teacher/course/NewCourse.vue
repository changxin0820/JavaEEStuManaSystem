<template>
<el-card style="width: 50%">
  <el-form :model="newCourseData" :rules="rules" ref="newCourseData" style="float: left"  label-width="100px" >
    <el-form-item   label="课程名称" prop="name">
      <el-input class="formItem" v-model="newCourseData.name"></el-input>
    </el-form-item>
    <el-form-item  label="学分" prop="credit">
      <el-select class="formItem" v-model="newCourseData.credit" placeholder="请选择学分">
        <el-option label="1" value="1"></el-option>
        <el-option label="2" value="2"></el-option>
        <el-option label="3" value="3"></el-option>
        <el-option label="4" value="4"></el-option>
        <el-option label="5" value="5"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="上课时间" >
        <el-select class="formItem" v-model="whichweekday" placeholder="请选择日期">
          <el-option v-for="(item,index) in weekday" :label="item" :value="item" :key="index"></el-option>
        </el-select>
        <el-time-select
          class="formItem"
          placeholder="起始时间"
          v-model="whichtimestart"
          :picker-options="{
              start: '08:00',
              step: '00:05',
              end: '20:55'
            }">
        </el-time-select>
        <el-time-select
          class="formItem"
          placeholder="结束时间"
          v-model="whichtimeend"
          :picker-options="{
              start: '08:00',
              step: '00:05',
              end: '20:55',
              minTime:whichtimestart
            }">
        </el-time-select>
    </el-form-item>
    <el-form-item label="课程性质" prop="status" >
      <el-select class="formItem" v-model="newCourseData.status" >
        <el-option v-for="(item,index) in statusArray" :label="item.label" :value="item.status" :key="index" ></el-option>

      </el-select>
    </el-form-item>
    <el-form-item label="课时" prop="period" >
      <el-select class="formItem" v-model="newCourseData.period" >
        <el-option v-for="(item,index) in periodArray" :label="item" :value="item" :key="index" ></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="上课地点" prop="place">
      <el-input class="formItem" v-model="newCourseData.place"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button class="formItem" type="primary" @click="submitForm()">提交</el-button>

    </el-form-item>
  </el-form>
</el-card>
</template>

<script>
export default {
  name: "newCourse",
  props:{
id:'',
  },
  data(){
    return{
      newCourseData:{
        name:"",
        credit: "",
        status: "",
        period: "",
        time: "",
        place: "",
        teacherId:""
      },
      weekday:["周一","周二","周三","周四","周五","周六","周日"],
      periodArray:[48,52,64],
      whichweekday:"",
      whichtimestart:"",
      whichtimeend:"",
      teacherId: 1,
      statusArray:[
        {
          status:"1",
          label:"必修"
        },
        {
          status:"0",
          label:"选修"
        }
      ],
      rules: {
        name: [
          { required: true, message: '请输入课程名称', trigger: 'blur' },
          { min: 2, max: 15, message: '长度在  到 15个字符', trigger: 'blur' }
        ],
        credit:[
          {required: true, message: '请选择学分', trigger: 'blur'}
        ],
        status:[
          {required: true, message: '请选择课程性质', trigger: 'blur'}
        ],
        period:[
          {required: true, message: '请选择课时', trigger: 'blur'}
        ],
        place:[
          {required: true, message: '请输入上课地点', trigger: 'blur'}
        ]



      }
    }

  },
  methods:{
    submitForm(){
      this.newCourseData.time=this.whichweekday+" "+this.whichtimestart+"-"+this.whichtimeend;
      this.newCourseData.teacherId=this.teacherId;
      this.$axios.post('/api/course/createCourse',{
        credit:this.newCourseData.credit,
        name: this.newCourseData.name,
        period: this.newCourseData.period,
        place: this.newCourseData.place,
        status: this.newCourseData.status,
        teacherId: this.id,
        time:this.newCourseData.time

      }).then(res=>{
        console.log(res);



      }).catch(error=>{

        this.$message.error(error);
      });
    },
    resetForm(){

    }
  }
}
</script>

<style scoped>
.formItem {
  float: left;
}
</style>
