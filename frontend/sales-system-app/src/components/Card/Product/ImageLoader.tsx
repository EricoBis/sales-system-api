'use client';

import React, { useState } from 'react';
import { Skeleton, Image } from '@nextui-org/react';

interface imageProps {
    imageUrl: string;
    alt: string
}

const ImageLoader = ({ imageUrl, alt }: imageProps) => {
  const [loaded, isLoaded] = useState(false);

  const handleLoad = () => {
    isLoaded(true);
  };

  return (
    <>
      {!loaded && <Skeleton className="rounded-lg w-48 h-72 mt-5"></Skeleton>}
      <Image
        shadow="sm"
        radius="lg"
        className="h-72 w-full object-cover"
        alt={alt}
        src={imageUrl}
        style={{ display: loaded ? 'block' : 'none' }}
        onLoad={handleLoad}
      />
    </>
  );
};

export default ImageLoader;