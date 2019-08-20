import React from 'react';
import MaterialTable from 'material-table';

export default function Admin() {
  const [state, setState] = React.useState({
    columns: [
      { title: 'FirstName', field: 'firstname' },
      { title: 'Last Name', field: 'lastname' },
      { title: 'Email', field: 'email', type: 'string' },
      { title: 'Phone',field: 'phone',type:'numeric'},
    ],
    data: [
      { firstname: 'Mehmet', lastname: 'Baran', email: 'eanj@mial.com', phone: 9887656666 },
      { firstname: 'chaman', lastname: 'tappu', email: 'dsdeanj@mial.com', phone: 988765966 },
      { firstname: 'naman', lastname: 'hoodi', email: 'eadsdnj@mial.com', phone: 9887656866 },
      { firstname: 'kalu', lastname: 'pvr', email: 'eadsnj@mial.com', phone: 988765666 },
      { firstname: 'pappu', lastname: 'data', email: 'eadsdnj@mial.com', phone: 988765666 },
      { firstname: 'raja', lastname: 'name', email: 'eandsj@mial.com', phone: 988765466 },
      { firstname: 'bheem', lastname: 'cuh bhi', email: 'eanaaj@mial.com', phone: 9887656666 },
      { firstname: 'modi', lastname: 'ji', email: 'eanwwj@mial.com', phone: 9887652666 },
    ],
  });

  function handle(event,rowData){
    console.log(rowData);
  }

  return (
    <MaterialTable
      title="User List"
      columns={state.columns}
      data={state.data}
      //onRowClick={(event,data)=> handle(event,data)}
      options={{
                actionsColumnIndex:4,
              }}
      actions={[
          {
            title:'Edit',
            icon: 'edit',
            tooltip: 'Edit Profile',
            onClick: (event, rowData) => handle(event,rowData)
          }
        ]}
    />
  );
}
