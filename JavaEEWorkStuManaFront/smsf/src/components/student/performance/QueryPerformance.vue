<template>
    <div>
      <!--面包屑导航区域-->
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/Welcome' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>我的成绩</el-breadcrumb-item>
        <el-breadcrumb-item>查询成绩</el-breadcrumb-item>
      </el-breadcrumb>
      <!--卡片视图区域-->
      <el-card>
        <!--搜索与添加区域-->
        <el-row :gutter="20">
          <el-col :span="7">
            <el-input placeholder="请输入内容" v-model="queryword" clearable @clear="clearWord"><el-button slot="append" icon="el-icon-search" @click="queryCourse"></el-button></el-input>
          </el-col>
        </el-row>
        <!--成绩列表区域-->
        <el-table :data="dd" stripe>
          <el-table-column type="index" width="50"></el-table-column>
          <el-table-column prop="course" label="科目" width="100"></el-table-column>
          <el-table-column prop="score" label="成绩" width="100"></el-table-column>
        </el-table>
        <!--分页区域-->
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="current_page"
          :page-sizes="[1, 2, 5, 10]"
          :page-size="page_size"
          layout="total, sizes, prev, pager, next, jumper"
          :total="scoreList.length">
        </el-pagination>

      </el-card>
    </div>
</template>

<script>
    export default {
        name: "QueryPerformance",
        created() {
            this.getPerformance();
        },
        data() {
            return {
                //scoreList数组存放所有的成绩
                scoreList:[],
                //每一页显示的数据条数
                page_size:5,
                //当前处于哪一页
                current_page:1,
                //dd数组用于存放当前页面下，当前每页数据条数下的成绩
                dd: [],
                //用于接收服务器发来的数据
                reportcard:{},
                //用于搜索成绩字符串
                queryword:''
            }
        },
        methods: {
            //监听每页显示多少数据改变的事件
            handleSizeChange(newSize) {
                this.page_size = newSize;
                this.queryword='';//清除搜索框的数据
                this.setData(); //给dd数组赋值
            },
            //监听页码值改变的事件
            handleCurrentChange(newPage) {
                this.current_page = newPage;
                this.queryword='';//清除搜索框的数据
                this.setData(); //给dd数组赋值
            },
            //根据页码值和每页显示的数据，将scoreList数组中某一区域的数据赋值给dd数组
            setData(){
                console.log("每页显示的条数");
                console.log(this.page_size);
                console.log("在哪一页");
                console.log(this.current_page);

                const start = this.page_size * (this.current_page-1);
                var end = this.page_size * this.current_page ;
                console.log("开始");
                console.log(start);
                console.log("结束");
                console.log(end);


                if(end>= this.scoreList.length + 1) {
                    end = this.scoreList.length + 1
                }
                this.dd = this.scoreList.slice(start, end)
            },
            //从服务器中查询所有成绩
            getPerformance() {
                var that = this;
                this.$axios.get('/api/performance/reportcard')
                    .then(function (response) {
                        console.log("------------------------");
                        console.log(response); //输出服务器返回的原始数据，类型为String，格式是Json
                        console.log(response.data);
                        console.log(response.data.performance);
                        console.log("------------------------");
                        that.reportcard = JSON.parse(response.data.performance); //将json格式的字符串转成json数据

                        var jsonstr = that.reportcard; //获取到的json数据不可用，故需要改造
                        var keyarr = [];  //存储key
                        var valarr = [];  //存储val
                        var sssssssssssaf =[];
                        for(var key in jsonstr){
                            keyarr.push(key);
                            valarr.push(jsonstr[key]);
                        }

                        for(var i =0;i<valarr.length;i++){
                            var jjjj={};  //存放临时的json数据
                            jjjj.course=keyarr[i];
                            jjjj.score=valarr[i];

                            //得到jjjjj={course:"值1",score:"值2"}
                            sssssssssssaf.push(jjjj);

                            //此时sssssssssssaf=[{course:"值1",score:"值2"},...,{course:"值1",score:"值2"}]
                        }
                        that.scoreList = sssssssssssaf;

                        that.dd = that.scoreList.slice(0,5);
                    })
                    .catch(function (error) {
                        console.log(error)
                    })

            },
            //按名称查询成绩
            queryCourse(){
                console.log("查询开始");
                var query = [];
                for(var i=0;i<this.scoreList.length;i++){
                    var item = this.scoreList[i];
                    var obj = eval(item);
                    if(obj.course===this.queryword){
                        query.push(item)
                    }
                }
                this.dd = query;
                console.log("查询结束");
            },
            //清空搜索框的内容触发事件
            clearWord(){
                this.queryword='';
                this.setData(); //给dd数组赋值
            }

        }

    }
</script>

<style scoped>

</style>
