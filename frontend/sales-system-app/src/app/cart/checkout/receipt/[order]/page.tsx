import Receipt from '@/components/Receipt/Receipt'
import React from 'react'

function page({ params }: { params: { order: string } }) {

  return (
    <Receipt order={params.order}/>
  )
}

export default page