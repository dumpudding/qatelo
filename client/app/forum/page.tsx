"use client";

import React, { useState } from "react";
import Image from "next/image";

const Forum = () => {
  // Sample forum posts data
  const [posts] = useState([
    {
      id: 1,
      name: "Name lastName",
      text: "Lorem ipsum, sample text, edited in markdown.",
      image: "/design_folder/sample.jpg", // Change to your actual image path
    },
    {
      id: 2,
      name: "Another User",
      text: "This is another sample post, markdown-supported.",
      image: "", // No image
    },
    {
      id: 3,
      name: "Third User",
      text: "This one has an image as well!",
      image: "/design_folder/sample2.jpg",
    },
  ]);

  return (
    <div className="min-h-screen bg-gray-900">
      {/* Search Bar */}
      <div className="bg-yellow-300 p-4">
        <input
          type="text"
          placeholder="Search bar"
          className="w-full p-2 rounded-md border border-gray-300"
        />
      </div>

      {/* Posts Section */}
      <div className="p-6">
        {posts.map((post, index) => (
          <div
            key={post.id}
            className={`p-6 ${index % 2 === 0 ? "bg-white" : "bg-gray-300"} rounded-md mb-4`}
          >
            {/* Post Header */}
            <div className="flex items-center space-x-4">
              {/* Profile Picture Placeholder */}
              <div className="w-10 h-10 bg-gray-400 rounded-full"></div>

              {/* Name */}
              <h2 className="font-bold">{post.name}</h2>
            </div>

            {/* Post Content */}
            <p className="mt-2 text-sm">{post.text}</p>

            {/* Optional Image */}
            {post.image && (
              <div className="mt-4">
                <Image
                  src={post.image}
                  alt="Post Image"
                  width={200}
                  height={200}
                  className="rounded-md"
                />
              </div>
            )}

            {/* Interaction Icons */}
            <div className="flex items-center space-x-4 mt-4 text-gray-600">
              {/* Like Button */}
              <button className="flex items-center space-x-1">
                ❤️ <span className="text-sm">Like</span>
              </button>

              {/* Comment Button */}
              <button className="flex items-center space-x-1">
                💬 <span className="text-sm">Comment</span>
              </button>

              {/* Share Button */}
              <button className="flex items-center space-x-1">
                🔄 <span className="text-sm">Share</span>
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Forum;
