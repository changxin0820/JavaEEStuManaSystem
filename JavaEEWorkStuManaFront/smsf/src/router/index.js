import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import StudentHome from "../components/student/StudentHome";
import MineCourse from "../components/student/course/MineCourse";
import SelectCourse from "../components/student/course/SelectCourse";
import StudentInfo from "../components/student/information/StudentInfo";
import UpdatePass from "../components/student/information/UpdatePass";
import QueryPerformance from "../components/student/performance/QueryPerformance";
import Login2 from "../components/Login2";
import TeacherHome from "../components/teacher/TeacherHome";
import NewCourse from "../components/teacher/course/NewCourse";
import AddPerformance from "../components/teacher/course/AddPerformance";
import Welcome from "../components/Welcome";
import StudentInsert from "../components/StudentInsert";
import StudentInfoManagement from "../components/StudentInfoManagement";
import StudentUpdate from "../components/StudentUpdate";
import AStudentInfo from "../components/AStudentInfo";
import UserManage from "../components/UserManage";

Vue.use(Router)

const router = new Router({
          routes: [
            {path: '/',component: Login2},
            {path: '/StudentHome',component: StudentHome,redirect:'/Welcome',
              children:[
                {path: '/Welcome',component: Welcome},
                {path: '/MineCourse',component: MineCourse},
                {path: '/SelectCourse',component: SelectCourse},
                {path: '/StudentInfo',component: StudentInfo},
                {path: '/UpdatePass',component: UpdatePass},
                {path: '/QueryPerformance',component: QueryPerformance},
              ]},

            {path: '/TeacherHome',component: TeacherHome,
              children:[
                {path: '/Welcome',component: Welcome},
                {path: '/NewCourse',component: NewCourse},
                {path: '/AddPerformance',component: AddPerformance},
                {path: '/StudentInsert',component: StudentInsert},
                {path: '/StudentInfoManagement',component: StudentInfoManagement},
                {path: '/AStudentInfo',component: AStudentInfo },
                {path: '/StudentUpdate',component: StudentUpdate},
                {path: '/UserManage',component: UserManage},
              ]},

            {path: '/HelloWorld',component: HelloWorld}
        ]
    }
)
//挂载路由导航守卫
router.beforeEach((to, from, next) => {
  if(to.path==="/") return next();
  const tokenStr = window.sessionStorage.getItem('token');
  if(!tokenStr) return next('/');
  next()

})


export default router
