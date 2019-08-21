import React,{Component} from 'react';
import MaterialTable from 'material-table';
import axios from 'axios';



export default class Admin extends Component {

    constructor(){
        super();
        //this.fun=this.fun.bind(this);
        this.state={
            columns:[
              { title: 'FirstName', field: 'fname' },
              { title: 'Last Name', field: 'lname' },
              { title: 'Email', field: 'email', type: 'string' },
              { title: 'Phone',field: 'phone',type:'numeric'},
            ],
            data:[]
        }
         
    }

    componentDidMount(){
      axios.get('http://localhost:8020/getAll')
        .then(res => {
          this.setState({
            data:res.data
          });

          console.log(res.data);
        })
     }

    handle(event,rowData){
    console.log(rowData);
  }

 

    render(){
        console.log(this);
        return  (
            <MaterialTable
              title="User List"
              columns={this.state.columns}
              data={this.state.data}
              //onRowClick={(event,data)=> handle(event,data)}
              options={{
                        actionsColumnIndex:4,
                      }}
              actions={[
                  {
                    title:'Edit',
                    icon: 'edit',
                    tooltip: 'Edit Profile',
                    onClick: (event, rowData) => this.handle(event,rowData)

                  }
                ]}
            />
        );
    }
}