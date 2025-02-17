"use client"; // Ensures this runs on the client-side

import Image from "next/image";
import React from "react";

const Profile = () => {
  return (
    <div className="min-h-screen flex flex-col justify-between bg-white text-black">
      {/* Profile Section */}
      <div className="max-w-3xl w-full mx-auto p-6">
        {/* Header */}
        <div className="relative flex items-center">
          {/* Profile Image (Now Aligned to Match Image) */}
          <div className="w-16 h-16 bg-gray-500 rounded-full flex items-center justify-center absolute left-4 border-2">
            <span className="text-white text-xs">Profile</span>
          </div>

          {/* Name & Major Bar (Now Centered) */}
          <div className="flex-1 bg-gray-300 px-6 py-3 rounded-lg flex justify-center">
            <h1 className="text-xl font-bold">
              Anna Ryerson - <span className="font-normal">Computing Science</span>
            </h1>
          </div>
        </div>

        {/* About Me Section */}
        <div className="mt-6">
          <h2 className="text-lg font-bold">About me</h2>
          <div className="bg-gray-300 p-4 rounded-md mt-2">
            <p className="font-semibold">Current president of <b>AuRA!</b></p>
            <p className="text-sm mt-1">
              I am a second-year CS student. I like going to rock concerts, my favorite and most recent one is Peach Pit.
            </p>
            <p className="text-sm mt-2">
              UAlberta email: <b>aryer2@ualberta.ca</b>
            </p>
          </div>
        </div>

        {/* Clubs Section */}
        <div className="mt-8 mb-12">  {/* Increased margin-bottom for extra space */}
          <h2 className="text-lg font-bold">Clubs</h2>
          <div className="mt-6 space-y-6">
            {/* Club 1 */}
            <div className="relative flex items-center">
              <div className="w-12 h-12 bg-gray-500 rounded-full flex items-center justify-center absolute left-0 z-10">
                <span className="text-white text-xs">Logo</span>
              </div>
              <div className="flex-1 bg-gray-300 rounded-lg p-2 pl-16 h-8 flex items-center">
                <p className="text-sm">AuRa</p>
              </div>
            </div>

            {/* Club 2 */}
            <div className="relative flex items-center">
              <div className="w-12 h-12 bg-gray-500 rounded-full flex items-center justify-center absolute left-0 z-10">
                <span className="text-white text-xs">Logo</span>
              </div>
              <div className="flex-1 bg-gray-300 rounded-lg p-2 pl-16 h-8 flex items-center">
                <p className="text-sm">UA Photography Club</p>
              </div>
            </div>

            {/* Club 3 */}
            <div className="relative flex items-center">
              <div className="w-12 h-12 bg-gray-500 rounded-full flex items-center justify-center absolute left-0 z-10">
                <span className="text-white text-xs">Logo</span>
              </div>
              <div className="flex-1 bg-gray-300 rounded-lg p-2 pl-16 h-8 flex items-center">
                <p className="text-sm">Hackers!!!!!</p>
              </div>
            </div>
          </div>
        </div>
      </div>

      {/* Bottom Yellow Bar (Integrated, No Shadow) */}
      <div className="bg-yellow-400 text-right p-2">
        <button className="text-sm font-semibold underline">Edit profile</button>
      </div>
    </div>
  );
};

export default Profile;
