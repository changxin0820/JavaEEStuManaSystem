<template>
  <el-container style=" height: 500px; width:80% ;border: 1px solid #efe0b0; border-radius: 12px">
    <el-header style="height: 100px">
      <div>
        <div style="text-align: center; font-size: 24px;color:#1d58bf">
          <span>学籍管理</span>
        </div>

        <el-divider></el-divider>
        <el-divider></el-divider>
        <div style="text-align: center; font-size: 20px; font-weight:normal; color:#000000">
          <span>学生学籍更新</span>
        </div>
      </div>
    </el-header>

    <el-main>

      <!-- 单条学生数据插入 -->
      <div>

        <el-form :model="insertOneForm" ref="insertOneForm" :rules="insertOneInfoRules">
          <el-form-item label="学号" :label-width="labelWidth" prop="id">
            <el-input
              class="formItem"
              clearable
              v-model="insertOneForm.id"
              placeholder="请输入学号..."
              auto-complete="off"
              style="width: 220px">
            </el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="labelWidth" prop="name">
            <el-input
              class="formItem"
              clearable
              v-model="insertOneForm.name"
              placeholder="请输入姓名..."
              auto-complete="off"
              style="width: 220px">
            </el-input>
          </el-form-item>
          <el-form-item label="性别" :label-width="labelWidth" prop="sex">
            <el-radio-group class="formItem" v-model="insertOneForm.sex" style="margin-top: 13px">
              <el-radio :label="'男'">男</el-radio>
              <el-radio :label="'女'">女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="身份证号" :label-width="labelWidth" prop="idCard">
            <el-input
              class="formItem"
              clearable
              v-model="insertOneForm.idCard"
              placeholder="请输入身份证号..."
              auto-complete="off"
              style="width: 220px">
            </el-input>
          </el-form-item>
          <el-form-item label="民族" :label-width="labelWidth" prop="nation">
            <el-input
              class="formItem"
              clearable
              v-model.number="insertOneForm.nation"
              placeholder="请输入民族..."
              auto-complete="off"
              style="width: 220px">
            </el-input>
          </el-form-item>
          <el-form-item label="籍贯" :label-width="labelWidth" prop="nativePlace">
            <el-input
              class="formItem"
              clearable
              v-model.number="insertOneForm.nativePlace"
              placeholder="请输入籍贯..."
              auto-complete="off"
              style="width: 220px">
            </el-input>
          </el-form-item>
          <!--          修改-->
          <el-form-item label="出生日期" :label-width="labelWidth" prop="birth">
            <el-date-picker
              class="formItem"
              v-model="insertOneForm.birth"
              type="date"
              placeholder="出生日期..."
              value-format="yyyy-MM-dd"
              style="width: 220px">
            </el-date-picker>
            <!--            修改-->
          </el-form-item>
          <el-form-item label="政治面貌" :label-width="labelWidth" prop="politicsStatus">
            <el-select class="formItem" v-model="insertOneForm.politicsStatus" clearable
                       placeholder="请选择政治面貌..." style="width: 220px">
              <el-option
                v-for="item in allPoliticsStatus"
                :key="item.id"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <!--          修改-->
          <el-form-item label="学院" :label-width="labelWidth" prop="academyId">
            <el-select class="formItem" v-model.number="insertOneForm.academyId" clearable
                       @visible-change="academySelectChange" placeholder="请选择学院..." style="width: 220px">
              <el-option
                v-for="item in allAcademies"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <!--          修改-->
          <el-form-item label="专业" :label-width="labelWidth" prop="majorId">
            <el-select class="formItem" v-model.number="insertOneForm.majorId" clearable
                       @visible-change="majorSelectChange" placeholder="请选择专业..." style="width: 220px">
              <el-option
                v-for="item in allMajors"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="年级" :label-width="labelWidth" prop="grade">
            <el-input
              class="formItem"
              clearable
              v-model.number="insertOneForm.grade"
              placeholder="请输入年级..."
              auto-complete="off"
              style="width: 220px">
            </el-input>
          </el-form-item>
          <el-form-item label="电话号码" :label-width="labelWidth" prop="phoneNum">
            <el-input
              class="formItem"
              clearable
              v-model.number="insertOneForm.phoneNum"
              placeholder="请输入电话号码..."
              auto-complete="off"
              style="width: 220px">
            </el-input>
          </el-form-item>
        </el-form>
      </div>
      <el-row>
        <el-button @click="UpdateOneStudent">
          更新
        </el-button>
      </el-row>
    </el-main>
  </el-container>

</template>

<script>
  export default {
    name: "StudentUpdate",
    props:{studentId:''},
    data() {
      return {

        labelWidth: '80px',
        insertOneForm: {
          id:'',
          name: '',
          sex: '',
          nation:'',
          politicsStatus:'',
          idCard:'',
          birth:'',
          academyId: '',
          academyName:'',
          majorId: '',
          majorName:'',
          phoneNum:'',
          grade:'',
          nativePlace:''
        },
        insertOneInfoRules: {
          id:[
            {required: true, message: '请输入学号', trigger: 'blur'}
          ],
          name: [
            {required: true, message: '请输入姓名', trigger: 'blur'},
          ],
          sex: [
            {required: true, message: '请选择性别', trigger: 'blur'},
          ],
          grade: [
            {required: true, message: '请输入年级', type: 'number'},
          ],
          nativePlace: [
            {required: true, message: '请输入籍贯', trigger: 'blur'},
          ],
          nation: [
            {required: true, message: '请输入民族', trigger: 'blur'},
          ],
          phoneNum: [
            {required: true, message: '请输入电话号码', trigger: 'blur'},
          ],
          politicsStatus: [
            {required: true, message: '请输入政治面貌', trigger: 'blur'},
          ],
          idCard: [
            {required: true, message: '请输入身份证号', trigger: 'blur'},
          ],
          academyId: [
            {required: true, message: '请选择学院信息', type: 'number', trigger: 'change'},
          ],
          majorId: [
            {required: true, message: '请选择专业信息', type: 'number', trigger: 'change'},
          ],
          birth: [
            {required: true, message: '请选择出生日期', trigger: 'blur'},
          ]
        },
        allAcademies: [],
        allMajors: [],
        allPoliticsStatus: [
          { id:1,
            value: '群众',
            label: '群众',
          },
          {
            id:2,
            value: '共青团员',
            label: '共青团员',
          },
          {
            id:3,
            value: '中共党员',
            label: '中共党员',
          }
        ],

      }
    },

    created() {

      this.initStudentUpdate()
    },
    methods: {

      initStudentUpdate(){
        this.insertOneForm.id=this.$route.query.id;
        this.insertOneForm.name=this.$route.query.name;
        this.insertOneForm.sex=this.$route.query.sex;
        this.insertOneForm.idCard=this.$route.query.idCard;
        this.insertOneForm.nation=this.$route.query.nation;
        this.insertOneForm.nativePlace=this.$route.query.nativePlace;
        this.insertOneForm.birth=this.$route.query.birth;
        this.insertOneForm.politicsStatus=this.$route.query.politicsStatus;
        this.insertOneForm.academyName=this.$route.query.academyName;
        this.insertOneForm.academyId=this.$route.query.academyId;
        this.insertOneForm.majorName=this.$route.query.majorName;
        this.insertOneForm.majorId=this.$route.query.majorId;
        this.insertOneForm.grade=this.$route.query.grade;
        this.insertOneForm.phoneNum=this.$route.query.phoneNum;
      },


      academySelectChange() {
        if ( this.allAcademies.length === 0) {
          this.$axios.get('/api/schoolInfo/findAllAcademies').then(resp => {
            this.allAcademies = resp.data;
          }).catch(error=>{
            this.$message.error(error);
          });
        }
      },

      majorSelectChange() {
        if(this.insertOneForm.majorId===''){
          if (this.insertOneForm.academyId === '') {
            this.$axios.get('/api/schoolInfo/findAllMajors').then(resp => {
              this.allMajors = resp.data;
            });
          } else if(this.insertOneForm.academyId !== '') {
            var academyId = this.insertOneForm.academyId;
            this.$axios.post('/api/schoolInfo/findMajorsByAcademyId',{id:this.insertOneForm.academyId}).then(resp => {
              this.allMajors = resp.data;
            });
          }
        }
        else {
          if (this.insertOneForm.academyId === '' && this.insertOneForm.majorId !== '') {
            var majorId =this.insertOneForm.majorId;
            this.$axios.post('/api/schoolInfo/findAcademyByMajorId',{id:this.insertOneForm.majorId}).then(resp => {
              this.academySelectChange();
              this.insertOneForm.academyId = resp.data.id;
            });
          }
        }
      },


      UpdateOneStudent(){
        if( this.insertOneForm.name!==''&&this.insertOneForm.id!=''){

          this.$axios.post('/api/studentInfo/updateStudentInfo', {

            id:this.insertOneForm.id,
            name:this.insertOneForm.name,
            sex:this.insertOneForm.sex,
            nation:this.insertOneForm.nation,
            politicsStatus:this.insertOneForm.politicsStatus,
            idCard:this.insertOneForm.idCard,
            birth:this.insertOneForm.birth,
            majorId:this.insertOneForm.majorId,
            academyId:this.insertOneForm.academyId,
            phoneNum:this.insertOneForm.phoneNum,
            grade:this.insertOneForm.grade,
            nativePlace:this.insertOneForm.nativePlace,
          }).then(res => {
            this.studentInfo = res.data;
            if(res.data){
              this.$message.success("更新成功");
              this.$router.push("/StudentInfoManagement")
            }
            else {
              this.$message.error("更新失败");
            }
          })
        }


      },
    },



  }
</script>

<style>

  .el-divider{
    margin: 5px 0;
    background: 0 0;
    border-top: 1px solid #000000;
  }

  .formItem {
    float: left;
  }


</style>
