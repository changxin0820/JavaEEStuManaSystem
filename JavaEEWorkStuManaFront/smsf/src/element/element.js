// 导入自己需要的组件
import {
  Button,
  Form,
  FormItem,
  Input,
  Message,
  Container,
  Header,
  Aside,
  Main,
  Menu,
  Submenu,
  MenuItemGroup,
  MenuItem,
  Breadcrumb,
  BreadcrumbItem,
  Card,
  Row,
  Col,
  Table,
  TableColumn,
  Pagination,
  Dialog} from "element-ui";
const element = {
  install: function (Vue) {
    Vue.use(Container)
    Vue.use(Header)
    Vue.use(Main)
    Vue.use(Button)
    Vue.use(Form)
    Vue.use(FormItem)
    Vue.use(Input)
    Vue.use(Aside)
    Vue.use(Menu)
    Vue.use(Submenu)
    Vue.use(MenuItemGroup)
    Vue.use(MenuItem)
    Vue.use(Breadcrumb)
    Vue.use(BreadcrumbItem)
    Vue.use(Card)
    Vue.use(Row)
    Vue.use(Col)
    Vue.use(Table)
    Vue.use(TableColumn)
    Vue.use(Pagination)
    Vue.use(Dialog)
    Vue.prototype.$message = Message
    // 解决首次进入自动弹出的问题
    Vue.component(Message.name, Message)
  }
}
export default element


