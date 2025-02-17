"use client";

import React, { useState } from "react";
import Image from "next/image";

const Profile = () => {
  const [notifications, setNotifications] = useState(false);

  return (
    <div className="w-full max-w-lg mx-auto bg-white shadow-lg rounded-lg overflow-hidden border border-gray-300">
      {/* Header */}
      <div className="bg-yellow-300 p-4 flex items-center justify-between">
        <h1 className="text-2xl font-serif text-gray-800">
          qatelo <span className="text-sm font-light">profile</span>
        </h1>
      </div>

      {/* Profile Content */}
      <div className="flex p-6">
        {/* Profile Image */}
        <div className="w-20 h-20 rounded-full overflow-hidden border-4 border-white shadow-lg">
          <Image
            src="/profile.jpg" // Make sure this image is inside /public/profile.jpg
            alt="Profile"
            width={80}
            height={80}
            className="object-cover"
          />
        </div>

        {/* Information */}
        <div className="ml-4 w-full">
          <div className="mb-2">
            <label className="font-semibold">Name:</label>
            <div className="bg-green-800 text-white rounded-md p-2">Anna Ryerson</div>
          </div>
          <div className="mb-2">
            <label className="font-semibold">Phone number:</label>
            <div className="bg-green-800 text-white rounded-md p-2">780-xxx-xxx</div>
          </div>
          <div className="mb-2">
            <label className="font-semibold">Bio:</label>
            <div className="bg-green-800 text-white rounded-md p-2">...</div>
          </div>
          <div className="mb-2">
            <label className="font-semibold">Address:</label>
            <div className="bg-green-800 text-white rounded-md p-2">...</div>
          </div>

          {/* Notifications Toggle */}
          <div className="flex items-center mt-4">
            <label className="font-semibold mr-2">Notifications:</label>
            <div
              className={`w-12 h-6 flex items-center rounded-full p-1 cursor-pointer transition-all duration-300 ease-in-out ${
                notifications ? "bg-yellow-500" : "bg-gray-300"
              }`}
              onClick={() => setNotifications(!notifications)}
            >
              <div
                className={`bg-green-800 w-5 h-5 rounded-full shadow-md transform transition-all duration-300 ${
                  notifications ? "translate-x-6" : "translate-x-0"
                }`}
              ></div>
            </div>
          </div>
        </div>
      </div>

      {/* Bottom Right Icon */}
      <div className="p-4 flex justify-end">
        <Image src="/icon.png" alt="Icon" width={40} height={40} />
      </div>
    </div>
  );
};

export default Profile;
