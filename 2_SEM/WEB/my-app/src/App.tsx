import React from 'react';
import logo from './logo.svg';
import './App.css';
import 'antd/dist/antd.min.css'
import { MoodyApp } from './components/MoodyApp';
import { QueryClient, QueryClientProvider } from 'react-query';
import './network/network-defaults'

function App() {

  const queryClient = new QueryClient({
    defaultOptions: {
      queries: {
        retry: false,
        refetchOnWindowFocus: false
      }
    }
  })

  return (
    <QueryClientProvider client={queryClient}>
    <div className="App">
      <MoodyApp />
    </div>
    </QueryClientProvider>
  );
}

export default App;
